package com.happy.glide;

import android.app.Activity;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.ImageViewState;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

import java.io.File;

public class MainActivity extends Activity {

    private SubsamplingScaleImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        imageView = (ImageView) findViewById(R.id.image_view);
        imageView = (SubsamplingScaleImageView) findViewById(R.id.imageView);

//        imageView.setMinimumScaleType(SubsamplingScaleImageView.SCALE_TYPE_CUSTOM);
        //最小显示比例
//        imageView.setMinScale(2.0F);
        imageView.setZoomEnabled(false);
//        imageView.setMaxScale(10.0F);//最大显示比例（太大了图片显示会失真，因为一般微博长图的宽度不会太宽）
    }

    public void loadImage(View view) {
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.mipmap.ic_launcher)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .error(R.mipmap.ic_launcher_round)
                .skipMemoryCache(true);
//        String url = "https://img10.360buyimg.com//imgzone//jfs//t16168//211//993976311//190955//ecedaf62//5a4b5d7dN55b437e7.jpg";
        String url = "https://img30.360buyimg.com//jgsq-productsoa//jfs//t9724//59//1430591780//2138721//c72f6394//59e0726aN1edf23c4.jpg";
        Glide.with(this)
                .load(url)
                .apply(requestOptions)
                .downloadOnly(new SimpleTarget<File>() {
                    @Override
                    public void onResourceReady(File resource, Transition<? super File> transition) {
                        imageView.setImage(ImageSource.uri(Uri.fromFile(resource)), new ImageViewState(1.4F, new PointF(0, 0), 0));
                    }
                });
    }

}
