package com.jibinfo.finance.utils;

import com.jibinfo.framework.image.AvatarUtils;
import com.jibinfo.framework.support.utility.Configuration;
import org.apache.commons.io.FileUtils;

import java.io.File;

public class FinanceAvatarUtils {
	
	/**
	 * 创建头像
	 * @param firstName
	 * @return
	 * @throws Exception
	 */
	public static String createAvatar(String firstName) throws Exception{
		firstName = firstName.toUpperCase();
		String rootPath = Configuration.getProperty("upload.avatar.image");
		String layerPath = "/avatar/";
		String suffix = ".jpg";
		File rootFile = new File(rootPath + layerPath);
		if(!rootFile.exists()){
			FileUtils.forceMkdir(rootFile);
		}
		File file = new File(rootPath + layerPath + firstName + suffix);
		AvatarUtils.createAvatar(firstName, file);
		return layerPath + firstName + suffix;
		
	}
}
