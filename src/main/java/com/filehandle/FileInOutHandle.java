package com.filehandle;

import com.filehandle.infc.HandleCommon;
import com.filehandle.infc.InOutHandleCommon;

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
public class FileInOutHandle implements InOutHandleCommon {

    private FileHandle fh = // 文件句柄
            null;

    private File f =
            null;

    public FileInOutHandle(FileHandle fh) {
        this.fh = fh;
    }

    public FileInOutHandle(File f) {
        this.f = f;
        this.fh = FileHandle.fromObject(f);
    }


    public static FileInOutHandle fromObject(Object obj) {
        FileInOutHandle rt = // 将要返回的FileHandle实例
                null;

        if ( File.class.isInstance(obj) ) {
            rt = new FileInOutHandle(new FileHandle((File) obj));
        } else if ( FileHandle.class.isInstance(obj) ) {
            rt = new FileInOutHandle((FileHandle) obj);
        } else if ( List.class.isInstance(obj) ) {

        }
        return rt;
    }

    public boolean touch(String path) {
        return false;
    }

    public boolean touch(File f) {
        return false;
    }

    public boolean move(String source, String target) {
        return false;
    }

    public boolean move(File source, String target) {
        return false;
    }

    public boolean copy(String source, String target) {
        return false;
    }

    public boolean copy(File source, String target) {
        return false;
    }

    public boolean delete(String source) {
        return false;
    }

    public boolean delete(File source) {
        return false;
    }
}
