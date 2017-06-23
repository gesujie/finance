package com.jibinfo.finance.utils;

import com.jibinfo.finance.dto.SpaceStatusDTO;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/5/22.
 */
public class DiskSpaceDetailUtils {


    public static void main(String[] args) {
        driver();
    }


    public static String FormetFileSize(long fileS) {
        DecimalFormat df = new DecimalFormat("#.00");
        String fileSizeString = "";
        if (fileS < 1024) {
            fileSizeString = df.format((double) fileS) + "B";
        } else if (fileS < 1048576) {
            fileSizeString = df.format((double) fileS / 1024) + "K";
        } else if (fileS < 1073741824) {
            fileSizeString = df.format((double) fileS / 1048576) + "M";
        } else {
            fileSizeString = df.format((double) fileS / 1073741824) + "G";
        }
        return fileSizeString;
    }

    /**
     * 获取硬盘的每个盘符
     */
    public static void driver(){
        // 当前文件系统类
        FileSystemView fsv = FileSystemView.getFileSystemView();
        // 列出所有windows 磁盘
        File[] fs = File.listRoots();
        // 显示磁盘卷标
        for (int i = 0; i < fs.length; i++) {
            System.out.println(fsv.getSystemDisplayName(fs[i]));
            System.out.print("总大小" + FormetFileSize(fs[i].getTotalSpace()));
            System.out.println("剩余" + FormetFileSize(fs[i].getFreeSpace()));
        }
    }


    public static List<SpaceStatusDTO> percentSpace(){
        List<SpaceStatusDTO> spaceStatusDTOList = new ArrayList<SpaceStatusDTO>();
        // 当前文件系统类
        FileSystemView fsv = FileSystemView.getFileSystemView();
        // 列出所有windows 磁盘
        File[] fs = File.listRoots();
        // 显示磁盘卷标
        for (int i = 0; i < fs.length; i++) {
            SpaceStatusDTO spaceStatusDTO = new SpaceStatusDTO();
            String spaceName = fsv.getSystemDisplayName(fs[i]);
            String total = FormetFileSize(fs[i].getTotalSpace());
            String usable = FormetFileSize(fs[i].getUsableSpace());
            String free = FormetFileSize(fs[i].getFreeSpace());


            spaceStatusDTO.setFree(free);
            spaceStatusDTO.setSpaceName(spaceName);
            spaceStatusDTO.setTotal(total);
            spaceStatusDTO.setUsable(usable);
            spaceStatusDTOList.add(spaceStatusDTO);

        }
        return spaceStatusDTOList;
    }







}
