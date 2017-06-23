package com.jibinfo.finance.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

/**
 * CreditToolUtil
 *
 * @author Vincentx
 * @version 1.0.0
 * @date 2017/5/25 15:24
 */
public class SensitiveFileUtil {
    private static Logger logger = Logger.getLogger(SensitiveFileUtil.class);
    public static String getPath(String rootPath){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String time =  simpleDateFormat.format(new Date());
        return rootPath + File.separator+File.separator+time;
    }
    public static void forceMkdir(File file) throws IOException {
        try {
            FileUtils.forceMkdir(file);
        } catch (IOException e) {
            logger.error("创建目录" + file.getAbsolutePath() + "失败");
            throw e;
        }
    }
    public static void saveFileFromInputStream(InputStream stream, String path, String filename) throws IOException {
        FileOutputStream fs=new FileOutputStream( path + "/"+ filename);
        byte[] buffer =new byte[1024*1024];
		// int bytesum = 0;
        int byteread = 0;
        while ((byteread=stream.read(buffer))!=-1)
        {
			// bytesum += byteread;
            fs.write(buffer,0,byteread);
            fs.flush();
        }
        fs.close();
        stream.close();
    }
}
