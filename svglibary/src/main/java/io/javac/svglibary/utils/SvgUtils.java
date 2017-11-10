package io.javac.svglibary.utils;

import android.graphics.Color;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import io.javac.svglibary.entity.SvgEntity;
import io.javac.svglibary.svgEnum.SvgConfig;

/**
 * Created by Pencilso on 2017/11/10.
 */

public class SvgUtils {
    public static SvgEntity config(String path, SvgConfig svgConfig) throws FileNotFoundException {
        return config(new FileInputStream(path), svgConfig);
    }

    public static SvgEntity config(InputStream path, SvgConfig svgConfig) {
        return getSvgContext(path, svgConfig);
    }

    public static SvgEntity config(String path) throws FileNotFoundException {
        return config(new FileInputStream(path), SvgConfig.GLYPHS_DEFAULT);
    }

    public static SvgEntity config(InputStream path) {
        return getSvgContext(path, SvgConfig.GLYPHS_DEFAULT);
    }


    /**
     * 获取Svg的内容
     *
     * @param inputStream SVG路径
     * @return
     */
    private static SvgEntity getSvgContext(InputStream inputStream, SvgConfig svgConfig) {
        XmlPullParser parser = Xml.newPullParser();
        SvgEntity svgEntity = new SvgEntity();
        List<Integer> colorArray = null;
        List<String> pathArray = null;
        try {
            parser.setInput(inputStream, "UTF-8");
            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:
                        colorArray = new ArrayList<>();
                        pathArray = new ArrayList<>();
                        break;
                    case XmlPullParser.START_TAG: {
                        switch (parser.getName()) {
                            case "svg":
                                String width = parser.getAttributeValue(2);
                                String[] split = width.split(" ");
                                svgEntity.setHeight(Float.valueOf(split[split.length - 1]));
                                svgEntity.setWidth(Float.valueOf(split[split.length - 2]));
                                break;
                            case "path":
                                String fill = parser.getAttributeValue(0);
                                String d = parser.getAttributeValue(2).trim();
                                colorArray.add(Color.parseColor(fill));
                                pathArray.add(d);
                                break;
                        }
                    }
                    break;
                    case XmlPullParser.END_TAG:
                        break;
                }
                eventType = parser.next();
            }
            Integer[] colorsInteger = colorArray.toArray(new Integer[colorArray.size()]);
            String[] glyphs = pathArray.toArray(new String[pathArray.size()]);
            int colors[] = new int[colorsInteger.length];
            for (int i = 0; i < colorsInteger.length; i++)
                colors[i] = colorsInteger[i];
            sort(glyphs, colors, svgConfig);
            svgEntity.setColors(colors);
            svgEntity.setGlyphs(glyphs);
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return svgEntity;
    }


    public static void sort(String[] glyphs, int[] colors, SvgConfig svgConfig) {
        if (svgConfig.equals(SvgConfig.GLYPHS_DEFAULT)) return;
        int size = colors.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (
                        (svgConfig.equals(SvgConfig.GLYPHS_SHORT_TO_GROW) && glyphs[j].length() > glyphs[j + 1].length()) ||
                                (svgConfig.equals(SvgConfig.GLYPHS_GROW_TO_SHORT) && glyphs[j].length() < glyphs[j + 1].length())
                        ) {
                    String temp = glyphs[j];
                    glyphs[j] = glyphs[j + 1];
                    glyphs[j + 1] = temp;

                    int iTemp = colors[j];
                    colors[j] = colors[j + 1];
                    colors[j + 1] = iTemp;
                }
            }
        }
    }
}
