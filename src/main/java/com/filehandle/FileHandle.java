package com.filehandle;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hsoft on 2017/8/28.
 */
public class FileHandle {

    private File fp = // 文件句柄
            null;
    private List<File> _fps = // 文件句柄集合
            new ArrayList<File>();

    /**
     *     提供了静态获取文件句柄的方法
     * @param path String 文件路径
     * @return File 文件操作句柄
     */
    public static File fromPath(String path) {
        File fp =
                new File(path);
        return fp;
    }

    /**
     *     从一个已知对象构建一个FileHandle实例
     * FileHandle提供此静态方法，以便于获取
     * 自身实例
     * @param obj
     * @return
     */
    public static FileHandle fromObject(Object obj) {
        FileHandle rt = // 将要返回的FileHandle实例
                null;

        if ( File.class.isInstance(obj) ) {
            rt = new FileHandle((File) obj);
        } else if ( String.class.isInstance(obj) ) {
            rt = new FileHandle((String) obj);
        } else if ( List.class.isInstance(obj) ) {

        }
        return rt;
    }

    public FileHandle() {}

    public FileHandle(String path) {
        fp =
                new File(path);
    }

    public FileHandle(File file) {
        fp =
                file;
    }

    public FileHandle(List<File> files) {

    }

    /**
     *     返回文件大小
     * @param unit String 返回值单位标记
     * @return String 文件大小
     */
    public String size(String unit) {
        long size =
                fp.length();
        String rt =
                null;

        if ( "kb".equals(unit) || "k".equals(unit) ) {
            rt = size / 1024 + ("." + size % 1024).substring(0, 2) + "KB";
        } else if ( "mb".equals(unit) || "m".equals(unit) ) {
            rt = size / (1024 * 1024) + ("." + size % (1024 * 1024)).substring(0, 2) + "MB";
        } else if ( "gb".equals(unit) || "g".equals(unit) ) {
            rt = size / (1024 * 1024 * 1024) + ("." + size % (1024 * 1024 * 1024)).substring(0, 2) + "GB";
        }

        return rt;
    }

    /**
     *     返回文件大小
     * @return
     */
    public Long size() {
        return fp.length();
    }

    /**
     *     返回File实例
     * @return
     */
    public File getFileHandle() {
        return this.fp;
    }
}
