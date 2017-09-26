package com.filehandle.infc;

import java.io.File;

/**
 * Created by Baichao Jiang on 2017/9/12.
 */
public interface InOutHandle {

    public boolean touch(String path);

    public boolean touch(File f);

    public boolean move(String source, String target);

    public boolean move(File source, String target);

    public boolean copy(String source, String target);

    public boolean copy(File source, String target);

    public boolean delete(String source);

    public boolean delete(File source);
}
