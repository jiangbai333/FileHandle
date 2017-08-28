package com.filehandle;

import java.io.File;

/**
 * Created by hsoft on 2017/8/28.
 */
public class FileHandle {

    public File fp = null;

    public static File fromPath(String path) {
        File fp =
                new File(path);
        return fp;
    }

    public FileHandle() {}

    public FileHandle(String path) {
        fp =
                new File(path);
    }

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

    public String sayHello() {
        return "hello world!";
    }
}
