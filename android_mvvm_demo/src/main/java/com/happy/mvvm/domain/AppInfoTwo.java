package com.happy.mvvm.domain;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.happy.mvvm.BR;
import com.happy.mvvm.R;

/**
 * Created by zhonglongquan on 2017/7/26.
 * ObservableField 支持的类型???
 * ObservableBoolean, ObservableByte, ObservableChar, ObservableShort,
 * ObservableInt, ObservableLong, ObservableFloat, ObservableDouble, ObservableParcelable
 */

public class AppInfoTwo extends BaseObservable {
    public final ObservableField<String> appName = new ObservableField<>();
    private final ObservableField<Long> intallTime = new ObservableField<>();
    private final ObservableField<Integer> clickNums = new ObservableField<>();
    private final ObservableField<String> versionName = new ObservableField<>();
    //    private final ObservableField<Drawable> icon = new ObservableField<>();
    private final ObservableField<String> packageName = new ObservableField<>();
    private Drawable icon;

    @BindingAdapter("bind:app_two_logo")
    public static void setLogo(ImageView imageView, Drawable drawable) {
        imageView.setImageResource(R.mipmap.ic_launcher);
    }

    public String getPackageName() {
        return packageName.get();
    }

    public void setPackageName(String packageName) {
        this.packageName.set(packageName);
    }

    public String getAppName() {
        return appName.get();
    }

    public void setAppName(String appName) {
        this.appName.set(appName);
    }

    public long getIntallTime() {
        return intallTime.get();
    }

    public void setIntallTime(long intallTime) {
        this.intallTime.set(intallTime);
    }

    public String getVersionName() {
        return versionName.get();
    }

    public void setVersionName(String versionName) {
        this.versionName.set(versionName);
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    @Bindable
    public int getClickNums() {
        return clickNums.get() == null ? 0 : clickNums.get();
    }

    public void setClickNums(int clickNums) {
        this.clickNums.set(clickNums);
        notifyPropertyChanged(BR.clickNums);
    }

    /**
     * 点击事件
     * 点击item获取当前position的数据，获取方式非常简单，直接get方法获取即可，比传统的ListView的点击事件通过position来获取数据方便多了
     *
     * @param view
     */
    public void onItemClick(View view) {
        Toast.makeText(view.getContext(), getAppName(), Toast.LENGTH_SHORT).show();
        setClickNums(getClickNums() + 1);
    }
}
