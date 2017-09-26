package com.filehandle;

import net.sf.json.JSONArray;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by hsoft on 2017/8/28.
 */
public class FileHandleTest {
    @Test
    public void testHello () {
        JSONArray jr =
                new JSONArray();
        jr.add("fuck");
        jr.add("you");
        for ( int i = 0; i < jr.size(); i++ ) {
            System.out.println(jr.getString(i));
        }
        System.out.println(jr.toArray());

        FileHandle fh = FileHandle.fromObject("../fileHandle");
        System.out.println(fh.getFileName());
        System.out.println(fh.size());
        System.out.println("11111111111");
        //Assert.assertEquals("hello world!", new FileHandle().sayHello());
    }
}
