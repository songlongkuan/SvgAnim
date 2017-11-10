package io.javac.svglibary.svgEnum;

/**
 * Created by Pencilso on 2017/11/10.
 */

public enum SvgConfig {
    /**
     * path 默认配置
     */
    GLYPHS_DEFAULT(),
    /**
     * path 从长到短 先后绘制
     */
    GLYPHS_GROW_TO_SHORT(),
    /**
     * path 从短到长 先后绘制
     */
    GLYPHS_SHORT_TO_GROW(),
    /**
     * path 随机绘制
     */
    GLYPHS_RANDOM;
}
