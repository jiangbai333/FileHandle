package com.filehandle;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by hsoft on 2017/8/28.
 */
public class FileHandleTest {
    @Test
    public void testHello () {
        System.out.println(FileHandle.fromPath("C:\\Users\\hsoft\\Desktop\\SpringMVC\\src"));
        Assert.assertEquals("hello world!", new FileHandle().sayHello());
    }
}
