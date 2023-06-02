package com.kenning.kcutil.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import androidx.appcompat.widget.AppCompatImageView;

import com.kenning.kcutil.R;

/**
 * Description :
 * author : KenningChen
 * Date : 2021/4/22 9:21 AM
 */
public class SwitchImageView extends AppCompatImageView {

    /**
     * 记录点击状态 默认未点击
     */
    private boolean checked = false;

    private Drawable mNormalDrawable;

    private Drawable mPressedDrawable;

    public SwitchImageView(Context context) {
        this(context, null);
    }

    public SwitchImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SwitchImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.SwitchImageView);
        mNormalDrawable = a.getDrawable(R.styleable.SwitchImageView_checkOffBackground);
        mPressedDrawable = a.getDrawable(R.styleable.SwitchImageView_checkOnBackground);
        checked = a.getBoolean(R.styleable.SwitchImageView_checkstate, false);
        a.recycle();

        setChecked(checked);

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                setChecked(!checked);
            }
        });

    }

    public void setOnSwitchListener(OnSwitchListener listener) {
        this.listener = listener;
    }

    private OnSwitchListener listener;

    public interface OnSwitchListener {
        void checkedChangeListener(boolean isChecked);
    }

    public void setmNormalDrawable(Drawable mNormalDrawable){
        this.mNormalDrawable = mNormalDrawable;
        setImageDrawable(mNormalDrawable);
    }

    public void setOffDrawable(Drawable mNormalDrawable){
        this.mNormalDrawable = mNormalDrawable;
    }

    public void setOnDrawable(Drawable mNormalDrawable){
        this.mPressedDrawable = mNormalDrawable;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
        if (checked) {
            setImageDrawable(mPressedDrawable);
        } else {
            setImageDrawable(mNormalDrawable);
        }
        if (listener!=null)
            listener.checkedChangeListener(checked);
    }

    public boolean getChecked(){
        return checked;
    }
}
