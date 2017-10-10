package com.hisign.framework.common.tfs;

public class FileUploadConfig {
	/** 上传模式  **/
	private String mode;
	/** ftp主机名称**/
	private String host;
	/** ftp 端口后 **/
	private String port;
	/** ftp用户名 **/
	private String user;
	/** ftp 密码**/
	private String password;
	/** 上传路径 **/
	private String rootPath;
	/** 缩略图宽度 **/
	private int thumbWidth = 160;
    /** 缩略图高度 **/
    private int thumbHeight = 160;
    
    
    public FileUploadConfig(){
    	
    }
    
	public FileUploadConfig(String mode, String host, String port, String user,
			String password, String rootPath, int thumbWidth, int thumbHeight) {
		this.mode = mode;
		this.host = host;
		this.port = port;
		this.user = user;
		this.password = password;
		this.rootPath = rootPath;
		this.thumbWidth = thumbWidth;
		this.thumbHeight = thumbHeight;
	}
	/**
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}
	/**
	 * @param mode the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}
	/**
	 * @param host the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}
	/**
	 * @return the port
	 */
	public String getPort() {
		return port;
	}
	/**
	 * @param port the port to set
	 */
	public void setPort(String port) {
		this.port = port;
	}
	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the rootPath
	 */
	public String getRootPath() {
		return rootPath;
	}
	/**
	 * @param rootPath the rootPath to set
	 */
	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}
	/**
	 * @return the thumbWidth
	 */
	public int getThumbWidth() {
		return thumbWidth;
	}
	/**
	 * @param thumbWidth the thumbWidth to set
	 */
	public void setThumbWidth(int thumbWidth) {
		this.thumbWidth = thumbWidth;
	}
	/**
	 * @return the thumbHeight
	 */
	public int getThumbHeight() {
		return thumbHeight;
	}
	/**
	 * @param thumbHeight the thumbHeight to set
	 */
	public void setThumbHeight(int thumbHeight) {
		this.thumbHeight = thumbHeight;
	}
	
    

}
