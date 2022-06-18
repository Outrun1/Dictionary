package com.example.userprofile23_1;

import org.junit.Test;

import static org.junit.Assert.*;

import android.util.Log;
import android.widget.Toast;

import com.example.userprofile23_1.Translate.Translate;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
//        String test = Translate.translate("你好");
//        System.out.println("百度翻译结果：\n" + test);
        assertEquals(4, 2 + 2);
    }
}