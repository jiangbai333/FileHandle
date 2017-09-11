package com.filehandle;

import com.filehandle.infc.HandleCommon;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 提供丰富的文件操作功能 </br>
 * Created by <b>Baichao Jiang</b> on 2017/8/28.
 * @author Baichao Jiang 姜柏超
 * </br>
 * </br> e-mail jiangbai333@gmail.com
 * </br> github https://github.com/jiangbai333
 * @version 0.2
 */
public class FileHandle implements HandleCommon {

    private File fp = // 文件句柄
            null;
    private List<File> _fps = // 文件句柄集合
            new ArrayList<File>();
    private String type = //文件类型
            null;
    private Long size = //文件大小
            null;
    private String name = //文件名称
            null;

    /**
     * 提供了静态获取文件句柄的方法
     * @param path 文件路径
     * @return 文件操作句柄
     */
    public static File fromPath(String path) {
        File fp =
                new File(path);
        return fp;
    }

    /**
     * 从一个已知对象构建一个FileHandle实例
     * FileHandle提供此静态方法，以便于获取
     * 自身实例
     * @param obj
     * @return 由obj构造的FileHandle实例
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
        this.setProto();
    }

    public FileHandle(File file) {
        fp =
                file;
        this.setProto();
    }

    public FileHandle(List<File> files) {}

    public String adaptiveSize(File fp) {
        return null;
    }

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

    public Long size(File fp) {
        return fp.length();
    }

    public String size(String unit) {
        return size(fp, unit);
    }

    public Long size() {
        return size(fp);
    }

    public List tree(File fp) throws IOException {
        List rt =
                new ArrayList();
        File[] fileList =
                fp.listFiles();

        if ( !fp.isDirectory() ) {
            return rt;
        }

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

    public Map fileInfo(File file) throws IOException {
        Map rt //返回值 Map
                = new HashMap();

        rt.put("name", file.getName());
        rt.put("path", file.getAbsolutePath());
        rt.put("size", size(file, "k"));
        rt.put("lastChangeTime", file.lastModified());

        return rt;
    }

    public File getFile() {
        return this.fp;
    }

    public String getFileType() {
        return this.type;
    }

    public String getFileName() {
        return this.name;
    }

    public boolean isDirectory() {
        return isDirectory(fp);
    }

    public boolean isDirectory(File fp) {
        return fp.isDirectory();
    }

    public List files(File dir) {
        List rt =
                new ArrayList();

        if ( this.isDirectory(dir) ) {
            File[] fileList =
                    dir.listFiles();

            for ( File tempFile : fileList ) {

                Map tempFileMap
                        = new HashMap();

                if ( tempFile.isDirectory() ) {
                    tempFileMap.put("type", "dir");
                } else {
                    tempFileMap.put("type", "file");
                }
                tempFileMap.put("name", tempFile.getName());
                tempFileMap.put("size", this.size(tempFile));

                rt.add(tempFileMap);
            }
        }
        return rt;
    }

    public List files() {
        return files(fp);
    }

    private void setProto() {
        this.size = this.size();
        this.name = this.fp.getName();
        this.type = null;
    }
}
