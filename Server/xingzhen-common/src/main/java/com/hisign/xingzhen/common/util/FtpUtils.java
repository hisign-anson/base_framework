package com.hisign.xingzhen.common.util;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author lqf
 * @E-mail:531941547@qq.com
 * @qq:531941547 
 * @version 创建时间：2014-2-16 下午03:06:58
 *
 */
public class FtpUtils {
	/* LOGGER */
	private static final Logger LOGGER = LoggerFactory.getLogger(FtpUtils.class);

	/* 上传主机(如果上传模式为ftp，则需要指定FTP服务器的相关信息，比如主机，端口，用户名，密码) */
	public static final String UPLOAD_HOST = "upload.host";

	/* 上传主机的端口 */
	public static final String UPLOAD_PORT = "upload.port";

	/* 上传主机的用户名 */
	public static final String UPLOAD_USER = "upload.user";

	/* 上传主机的密码 */
	public static final String UPLOAD_PASSWORD = "upload.password";

	/* 上传文件的根目录 */
	public static final String UPLOAD_ROOT_PATH = "upload.root.path";

	/* 上传代理主机(如果上传模式为ftp，则需要指定FTP服务器的相关信息，比如主机，用户名，密码) */
	public static final String UPLOAD_PROXY_HOST = "upload.proxy.host";

	/* 上传主机的端口 */
	public static final String UPLOAD_PROXY_PORT = "upload.proxy.port";

	/* 上传代主机的用户名 */
	public static final String UPLOAD_PROXY_USER = "upload.proxy.user";

	/* 上传代主机的密码 */
	public static final String UPLOAD_PROXY_PASSWORD = "upload.proxy.password";

	/* FTP客户端 */
	private FTPClient ftp;

	private static FtpUtils instance;

	/* 锁 */
	private static Object lock = new Object();
	
	private String host;
	private String hostPort;
	private String hostUserName;
	private String hostPassword;
	private String hostRootPath;

	/**
	 * 隐含的构造函数
	 */
	protected FtpUtils() {
		// 实例化FTP客户端对象
		this.ftp = new FTPClient();
		this.ftp.configure(getFTPClientConfig());
	}
	
	protected FtpUtils(String host,String port,String userName,String password,String rootPath) {
		// 实例化FTP客户端对象
		this.ftp = new FTPClient();
		this.ftp.configure(getFTPClientConfig());
		this.host=host;
		this.hostPort=port;
		this.hostUserName=userName;
		this.hostPassword=password;
		this.hostRootPath=rootPath;
	}

	/**
	 * 返回单例对象
	 * 
	 * @return
	 */
	public static FtpUtils getInstance() {
		synchronized (lock) {
			if (instance == null) {
				instance = new FtpUtils();
			}
		}
		return instance;
	}
	/**
	 * 返回单例对象
	 * 
	 * @return
	 */
	public static FtpUtils getInstance(String host,String port,String userName,String password,String rootPath) {
		synchronized (lock) {
			if (instance == null) {
				instance = new FtpUtils(host, port, userName, password, rootPath);
			}
		}
		return instance;
	}

	/**
	 * 连接FTP服务器
	 */
	public boolean connect() {
		int reply;
		try {
			if (ftp != null) {
				ftp.connect(getServer(), getPort());

				if (LOGGER.isInfoEnabled()) {
					LOGGER.info("[FTPHelper] Connected to "
							+ getServer()
							+ " on "
							+ (getPort() > 0 ? getPort() : ftp.getDefaultPort()));
				}

				reply = ftp.getReplyCode();

				if (!FTPReply.isPositiveCompletion(reply)) {
					ftp.disconnect();
					return false;
				}

				return true;
			}
		} catch (IOException ex) {
			LOGGER.error("FTP连接时发生异常", ex);
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException f) {
					LOGGER.error("断开FTP连接时发生异常", f);
				}
			}
		}
		return false;
	}

	/**
	 * 登录FTP服务器
	 * 
	 * @return
	 */
	public boolean login() {
		boolean success = false;
		try {
			success = ftp.login(getUsername(), getPassword());
			if (success) {
				// 设置FTP的一些属性
				ftp.setFileType(FTPClient.BINARY_FILE_TYPE); // 传输二进制文件
				ftp.enterLocalPassiveMode(); // 设置为被动模式
				ftp.setConnectTimeout(2000); // 超时时间
				// ftp.setControlEncoding("GBK"); //字符集

				if (LOGGER.isInfoEnabled()) {
					LOGGER.info("[FTPHelper] 登录FTP服务器成功，success=" + success
							+ ", username=" + getUsername());
				}
			} else {
				ftp.logout();
			}
		} catch (IOException ex) {
			LOGGER.error("登录FTP服务器时发生异常", ex);
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException f) {
					LOGGER.error("断开FTP连接时发生异常", f);
				}
			}
		}

		return success;
	}

	/**
	 * 向FTP指定路径上传文件
	 * 
	 * @param localFile
	 * @param newName
	 *            新文件名
	 * @param remoteFoldPath
	 * @throws Exception
	 */
	public boolean uploadFile(InputStream input, String remotePath) {
		boolean success = false;
		try {
			String filename="";
			try {
				filename = FilenameUtils.getName(remotePath);
			} catch (Exception e) {
				LOGGER.error("上传文件时发生异常", e);
			}
			String path = FilenameUtils.getPath(remotePath);
			// 创建目录
			createDirectory(path);
			success = ftp.storeFile(filename, input);
			if (LOGGER.isInfoEnabled()) {
				LOGGER.info("[FTPHelper] 上传文件成功，success=" + success
						+ ", filename=" + filename + ", path=" + getRootPath()+path);
			}
		} catch (Exception ex) {
			LOGGER.error("上传文件时发生异常", ex);
		} finally {
			IOUtils.closeQuietly(input);
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException f) {
					LOGGER.error("断开FTP连接时发生异常", f);
				}
			}
		}
		return success;
	}

	/**
	 * 删除文件
	 * 
	 * @param remotePath
	 * @throws UploadFileException
	 */
	public void deleteFile(String remotePath) {
		try {
			// 截取文件名和目录
			String filename = FilenameUtils.getName(remotePath);
			String path = FilenameUtils.getPath(remotePath);

			// 变换目录
			changeWorkingDirectory(getRootPath()+path);
			// 删除文件
			boolean success = ftp.deleteFile(filename);
			if(success){
				String[] s2=filename.split("\\.");
				ftp.deleteFile(s2[0]+"_thumb."+s2[1]);
			}
			if (LOGGER.isInfoEnabled()) {
				LOGGER.info("[FTPHelper] 删除上传文件完成，success=" + success
						+ ", remotePath=" + remotePath);
			}
		} catch (IOException ex) {
			LOGGER.error("删除FTP服务器文件时发生异常", ex);
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException f) {
					LOGGER.error("断开FTP连接时发生异常", f);
				}
			}
		}
	}

	/**
	 * 变换远程FTP目录
	 * 
	 * @param path
	 */
	public void changeWorkingDirectory(String path) {
		try {
			boolean flag = ftp.changeWorkingDirectory(path);
			if (flag) {
				// 如果变更当前目录成功，则表示当前目录存在
				return;
			} else {
				// 否则就进行逐层的目录变换
				if (StringUtils.startsWith(path, File.separator)) {
					path = StringUtils.substring(path, 1);
				}
				String[] dirs = StringUtils.split(path, File.separator);
				if (dirs.length <= 0) {
					// 如果目录为空，则退出递归
					return;
				} else {
					boolean success = ftp.changeWorkingDirectory(dirs[0]);
					if (LOGGER.isInfoEnabled()) {
						LOGGER.info("[FTPHelper] 变换文件夹完成，current.path="
								+ dirs[0] + ", success=" + success
								+ ", working.dir="
								+ ftp.printWorkingDirectory());
					}
					// 递归
					String next = StringUtils.substring(
							path,
							StringUtils.indexOf(path, dirs[0])
									+ dirs[0].length());
					changeWorkingDirectory(next);
				}
			}
		} catch (IOException ex) {
			LOGGER.error("改变服务器目录时发生异常", ex);
		}
	}

	/**
	 * 创建远程FTP目录
	 * 
	 * @param path
	 */
	public void createDirectory(String path) {
		try {
			boolean flag = ftp.changeWorkingDirectory(path);
			if (flag) {
				// 如果变更当前目录成功，则表示当前目录存在
				return;
			} else {
				// 否则就创建目录
				if (StringUtils.startsWith(path, File.separator)) {
					path = StringUtils.substring(path, 1);
				}
				String[] dirs = StringUtils.split(path, File.separator);
				if (dirs.length <= 0) {
					// 如果目录为空，则退出递归
					return;
				} else {
					if (!ftp.changeWorkingDirectory(dirs[0])) {
						ftp.makeDirectory(dirs[0]);
						ftp.changeWorkingDirectory(dirs[0]); // 进入创建的目录
					}

					// 递归
					String next = StringUtils.substring(
							path,
							StringUtils.indexOf(path, dirs[0])
									+ dirs[0].length());
					createDirectory(next);
				}
			}
		} catch (IOException ex) {
			LOGGER.error("改变服务器目录时发生异常", ex);
		}
	}

	/**
	 * 配置FTP连接参数
	 * 
	 * @return
	 * @throws Exception
	 */
	protected FTPClientConfig getFTPClientConfig() {
		String systemKey = FTPClientConfig.SYST_UNIX;
		// String serverLanguageCode = "zh";
		FTPClientConfig conf = new FTPClientConfig(systemKey);
		// conf.setServerLanguageCode(serverLanguageCode);
		conf.setDefaultDateFormatStr("yyyy-MM-dd");
		return conf;
	}

	/**
	 * 返回主机地址
	 * 
	 * @return
	 */
	public String getServer() {
		return StringUtils.isNotBlank(getHost())==true?getHost():System.getProperty(UPLOAD_HOST);
	}

	public String getProxyServer() {
		return System.getProperty(UPLOAD_PROXY_HOST);
	}

	public int getPort() {
		String config = StringUtils.isNotBlank(getHostPort())==true?getHostPort(): System.getProperty(UPLOAD_PORT);
		return  NumberUtils.toInt(config, 21);
	}

	public String getRootPath() {
		return StringUtils.isNotBlank(getHostRootPath())==true?getHostRootPath():System.getProperty(UPLOAD_ROOT_PATH);
	}

	public int getProxyPort() {
		String config = System.getProperty(UPLOAD_PROXY_PORT);
		return NumberUtils.toInt(config, 21);
	}

	public String getUsername() {
		return StringUtils.isNotBlank(getHostUserName())==true?getHostUserName():System.getProperty(UPLOAD_USER);
	}

	public String getProxyUsername() {
		return System.getProperty(UPLOAD_PROXY_USER);
	}

	public String getPassword() {
		return StringUtils.isNotBlank(getHostPassword())==true?getHostUserName():System.getProperty(UPLOAD_PASSWORD);
	}

	public String getProxyPassword() {
		return System.getProperty(UPLOAD_PROXY_PASSWORD);
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getHostPort() {
		return hostPort;
	}

	public void setHostPort(String hostPort) {
		this.hostPort = hostPort;
	}

	public String getHostUserName() {
		return hostUserName;
	}

	public void setHostUserName(String hostUserName) {
		this.hostUserName = hostUserName;
	}

	public String getHostPassword() {
		return hostPassword;
	}

	public void setHostPassword(String hostPassword) {
		this.hostPassword = hostPassword;
	}

	public String getHostRootPath() {
		return hostRootPath;
	}

	public void setHostRootPath(String hostRootPath) {
		this.hostRootPath = hostRootPath;
	}
}
