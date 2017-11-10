# SvgAnim
> PNG转SVG推荐 vmde工具

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

	dependencies {
		compile 'com.github.pencilso:SvgAnim:v1.0.2'
	}

> XML文件布局

	 <com.jaredrummler.android.widget.AnimatedSvgView
        android:id="@+id/animated_svg_view"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:layout_marginBottom="25dp"
        app:animatedSvgFillStart="1200"
        app:animatedSvgFillTime="1000"
        app:animatedSvgImageSizeX="400"
        app:animatedSvgImageSizeY="400"
        app:animatedSvgTraceTime="2000"
        app:animatedSvgTraceTimePerGlyph="1000" />

> 初始化配置

	 //路径为svg图片的路径
	 SvgEntity config = SvgUtils.config(getAssets().open("20171110143319.svg"), SvgConfig.GLYPHS_RANDOM);
	 //初始化 方法
	 //SvgUtils.config(String path);
	 //SvgUtils.config(InputStream path);

> 启动动画

	 animatedSvgView.setGlyphStrings(config.getGlyphs());
        animatedSvgView.setFillColors(config.getColors());
        animatedSvgView.setViewportSize(config.getWidth(), config.getWidth());
        animatedSvgView.setTraceResidueColor(0x32000000);
        animatedSvgView.setTraceColors(config.getColors());
        animatedSvgView.rebuildGlyphData();
        animatedSvgView.start();

> 效果预览

![](https://i.imgur.com/ko9ErrK.gif)