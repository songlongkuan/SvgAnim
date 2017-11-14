package io.javac.svganim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jaredrummler.android.widget.AnimatedSvgView;

import java.io.IOException;

import io.javac.svglibary.entity.SvgEntity;
import io.javac.svglibary.svgEnum.SvgConfig;
import io.javac.svglibary.utils.SvgUtils;

public class MainActivity extends AppCompatActivity {
    private AnimatedSvgView animatedSvgView;
    private SvgEntity config;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animatedSvgView = findViewById(R.id.animated_svg_view);
        try {
            config = SvgUtils.config(getAssets().open("20171110143319.svg"), SvgConfig.GLYPHS_SHORT_TO_GROW);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        animatedSvgView.setGlyphStrings(config.getGlyphs());
        animatedSvgView.setFillColors(config.getColors());
        animatedSvgView.setViewportSize(config.getWidth(), config.getWidth());
        animatedSvgView.setTraceResidueColor(0x32000000);
        animatedSvgView.setTraceColors(config.getColors());
        animatedSvgView.rebuildGlyphData();
        animatedSvgView.start();
    }
}