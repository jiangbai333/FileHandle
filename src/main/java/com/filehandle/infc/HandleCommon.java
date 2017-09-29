package com.filehandle.infc;

import com.filehandle.FileHandle;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 文件操作工具类接口</br>
 * Created by Baichao Jiang on 2017/8/31.
 * @author Baichao Jiang 姜柏超
 * </br>
 * </br> e-mail jiangbai333@gmail.com
 * </br> github https://github.com/jiangbai333
 * @version 0.2
 */
public interface HandleCommon extends Handle{


    /**
     * 当指定的文件资源为目录时，获取该目录下的文件树
     * @param fp 文件指针
     * @return 目录内文件树
     * @throws IOException
     * @see IOException
     * @see List
     */
    public List tree(File fp) throws IOException;

    /**
     * 当FileHandle实例所绑定的文件为目录时，获取该目录下的文件树
     * @return 文件树
     * @throws IOException
     * @see IOException
     * @see List
     */
    public List tree() throws IOException;

    /**
     * 获取目录下的文件列表
     * @param dir 目录名称
     * @return 目录内文件列表
     * @since v0.2
     * @see List
     */
    public List<File> filesList(File dir);

    /**
     * 获取FileHandle实例中所指向的目录下的文件列表
     * @return 目录内文件列表
     */
    public List<File> filesList();

    /**
     * 获取dir实例下的文件列表，保存在Map中，文件实例作为键值，文件名作为键名
     * @param dir
     * @return
     * @since v0.3
     * @see Map
     */
    public Map<String, File> filesMap(File dir);

    /**
     * 获取dir实例下的文件列表，保存在Map中，文件实例作为键值，文件名作为键名
     * @return
     * @since v0.3
     */
    public Map<String, File> filesMap();

    public List<FileHandle> getHandleList(File dir);

    public List<FileHandle> getHandleList();

    public Map<String, FileHandle> getHandleMap(File dir);

    public Map<String, FileHandle> getHandleMap();
}
