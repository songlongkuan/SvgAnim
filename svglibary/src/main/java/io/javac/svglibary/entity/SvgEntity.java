package io.javac.svglibary.entity;

import java.util.Arrays;

/**
 * Created by Pencilso on 2017/11/10.
 */

public class SvgEntity {
    private String[] glyphs;
    private int[] colors;
    private float width;
    private float height;

    public SvgEntity() {
    }

    public SvgEntity(String[] glyphs, int[] colors, float width, float height) {
        this.glyphs = glyphs;
        this.colors = colors;
        this.width = width;
        this.height = height;
    }

    public String[] getGlyphs() {
        return glyphs;
    }

    public void setGlyphs(String[] glyphs) {
        this.glyphs = glyphs;
    }

    public int[] getColors() {
        return colors;
    }

    public void setColors(int[] colors) {
        this.colors = colors;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "SvgEntity{" +
                "glyphs=" + Arrays.toString(glyphs) +
                ", colors=" + Arrays.toString(colors) +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
