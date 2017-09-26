package com.filehandle.infc;

import java.io.File;

/**
 * 文件操作的基本接口，定义需要实现的基本工具方法</br>
 * Created by Baichao Jiang on 2017/8/31.
 * @author Baichao Jiang 姜柏超
 * </br>
 * </br> e-mail jiangbai333@gmail.com
 * </br> github https://github.com/jiangbai333
 * @version 0.2
 */
public interface Handle {

    /**
     * 获取根据文件体积自动调整体积单位后的文件大小</br>
     * 单位将以kb、mb、gb表示，按照文档的实际大小，
     * 自动返回对应的单位
     * @param fp 文件实例
     * @return
     */
    public String adaptiveSize(File fp);

    /**
     * 根据<code>unit</code>参数所给出的单位标识返回文件大小</br>
     * 实例：</br>
     * FileHandle file = new FileHandle(File);</br>
     * file.size(file, "k")|fileHandle.size(file, "kb");  //以kb为单位 x.xxKB</br>
     * file.size(file, "m")|fileHandle.size(file, "mb");  //以kb为单位 x.xxMB</br>
     * file.size(file, "g")|fileHandle.size(file, "gb");  //以kb为单位 x.xxGB</br>
     * @param fp 文件指针
     * @param unit 返回值单位标记 可选值为[k|kb, m|mb, g|gb]
     * @return 文件大小
     */
    public String size(File fp, String unit);

    /**
     * 以字节为单位返回文件大小
     * @param fp File 文件指针
     * @return 文件大小
     */
    public Long size(File fp);

    /**
     * 返以字节为单位根据<code>unit</code>参数所给出的单位标识回文件大小
     * @param unit 返回值单位标记 可选值为[k|kb, m|mb, g|gb]
     * @return String 文件大小
     */
    public String size(String unit);

    /**
     * 以字节为单位返回文件大小，使用FileHandle实例内部指向文件的文件指针
     * @return
     */
    public Long size();

    /**
     * 获取当前FileHandle实例内部指向的File实例
     * @return 构建FileHandle实例时内部的File实例
     */
    public File getFile();

    /**
     * 获取当前FileHandle实例内部指向的File实例的文件类型
     * @return
     */
    public String getFileType();

    /**
     * 获取当前FileHandle实例内部指向的File实例的文件名
     * @return
     */
    public String getFileName();

    /**
     * 判断是否为目录</br>
     * 判断的File为FileHandle实例内部指向的File实例
     * @return 是否为目录
     */
    public boolean isDirectory();

    /**
     * 判断是否为目录
     * @param fp 要判断的文件
     * @return 是否为目录
     */
    public boolean isDirectory(File fp);

    /**
     * 判断FileHandle实例所指向的File实例是否存在
     * @return 文件是否存在
     */
    public boolean isExist();

    /**
     * 判断fp所指向的实例是否存在
     * @param fp
     * @return 文件是否存在
     */
    public boolean isExist(File fp);
}
