package com.hisign.xingzhen.common.tfs;

import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 创建随机文件名称的工具类
 */
public class CreateRandomFile {
	private final static String RANDOM_ALGORITHM = "SHA1PRNG";
	private final static String RANDOM_ALGORITHM_ALT = "IBMSecureRandom";
	private Random random;
	private boolean weakRandom;
	private HttpServletRequest request;
    public CreateRandomFile(){
    	
    }
	/**
	 * 构造方法
	 */
	public CreateRandomFile(HttpServletRequest request) {
		if (random == null) {
			try {
				random = SecureRandom.getInstance(RANDOM_ALGORITHM);
			} catch (NoSuchAlgorithmException e) {
				try {
					random = SecureRandom.getInstance(RANDOM_ALGORITHM_ALT);
					weakRandom = false;
				} catch (NoSuchAlgorithmException e_alt) {
					random = new Random();
					weakRandom = true;
				}
			}
		}
		random.setSeed(random.nextLong() ^ System.currentTimeMillis()
				^ hashCode() ^ Runtime.getRuntime().freeMemory());
		this.request = request;
	}

	/**
	 * @see com.lakala.bmcp.share.io.CreateRandomFile#create(String)
	 */
	public File create(String parent, String suffix) {
		String name = getName(); // 获取一个随机的文件名
		if (StringUtils.isNotBlank(name) && StringUtils.isNotBlank(suffix)) {
			name = name + "." + suffix;
		}

		return new File(parent, name);
	}
	public File create2(String parent, String suffix) {
		String name = getRandomFilename(); // 获取一个随机的文件名
		if (StringUtils.isNotBlank(name) && StringUtils.isNotBlank(suffix)) {
			name = name + "." + suffix;
		}
		return new File(name);
	}
	

	protected String getName() {
		String name = null;
		while (name == null || name.length() == 0) {
			long r = weakRandom
					? (hashCode() ^ Runtime.getRuntime().freeMemory()
							^ random.nextInt() ^ (((long) request.hashCode()) << 32))
					: random.nextLong();
			r ^= System.currentTimeMillis();
			if (request != null && request.getRemoteAddr() != null)
				r ^= request.getRemoteAddr().hashCode();
			if (r < 0)
				r = -r;
			name = Long.toString(r, 36);
		}
		return name;
	}
	protected  String getRandomFilename(){  
	       String fourRandom = "";
	       //产生4位的随机数(不足4位前加零)
	       int randomNum = (int)(Math.random()*10000);
	       fourRandom = randomNum +"";
	       int randLength =  fourRandom.length();
	       if(randLength <4){
	           for(int i=1; i <=4-randLength; i++)
	               fourRandom = fourRandom + "0";
	       } 
	       StringBuilder sb = new StringBuilder("");
	       Date date = new Date();
	       DateFormat dateFormat = new SimpleDateFormat("yyyyMM");
	       sb.append(dateFormat.format(date)).append(date.getTime()).append(fourRandom);
	       return sb.toString(); 
	    }
}
