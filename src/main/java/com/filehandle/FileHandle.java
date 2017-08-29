package com.filehandle;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public FileHandle(List<File> files) {}

    /**
     *     根据文件体积自动调整文件体积单位
     * @param fp
     * @return
     */
    public String adaptiveSize(File fp) {
        return null;
    }

    /**
     *     返回文件大小
     * @param fp String 文件指针
     * @param unit String 返回值单位标记
     * @return String 文件大小
     */
    public String size(File fp, String unit) {
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
     * @param fp File 文件指针
     * @return 文件大小
     */
    public Long size(File fp) {
        return fp.length();
    }

    /**
     *     返回文件大小
     * @param unit String 返回值单位标记
     * @return String 文件大小
     */
    public String size(String unit) {
        return size(fp, unit);
    }

    /**
     *     返回文件大小
     * @return
     */
    public Long size() {
        return size(fp);
    }

    /**
     *     获取文件树
     * @param fp
     * @return
     * @throws IOException
     */
    public List tree(File fp) throws IOException {
        List rt
                = new ArrayList();
        File[] fileList
                = fp.listFiles();

        for ( File tempFile : fileList ) {

            Map tempFileMap
                    = new HashMap();

            if ( tempFile.isDirectory() ) {
                tempFileMap.put("type", "dir");
                tempFileMap.put("child", tree(tempFile));
            } else {
                tempFileMap.put("type", "file");
            }

            tempFileMap.putAll(fileInfo(tempFile));
            rt.add(tempFileMap);
        }
        return rt;
    }

    public List tree() throws IOException {
        return tree(fp);
    }

    private Map fileInfo(File file) throws IOException {
        Map rt //返回值 Map
                = new HashMap();

        rt.put("name", file.getName());
        rt.put("path", file.getAbsolutePath());
        rt.put("size", size(file, "k"));
        rt.put("lastChangeTime", file.lastModified());

        return rt;
    }

    /**
     *     返回File实例
     * @return
     */
    public File getFileHandle() {
        return this.fp;
    }
}
