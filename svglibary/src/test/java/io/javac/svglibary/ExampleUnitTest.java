package io.javac.svglibary;

import org.junit.Test;

import io.javac.svglibary.entity.SvgEntity;
import io.javac.svglibary.utils.SvgUtils;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
        SvgEntity config = SvgUtils.config("E:/mmexport1507031142145.svg");
    }
}