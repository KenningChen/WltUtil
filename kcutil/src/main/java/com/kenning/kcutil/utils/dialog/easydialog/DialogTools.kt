package com.kenning.kcutil.utils.dialog.easydialog

import android.app.Activity
import android.content.Context
import com.kenning.kcutil.utils.math.toInt_
import com.kenning.kcutil.utils.other.ScreenUtil

/**
 *Description :
 *@author : KenningChen
 *Date : 2021/11/5
 */
class DialogTools {

    /**
     * 对话框宽度
     * -1为内部默认值
     */
    var dialogWidth = (ScreenUtil.getScreenWidth()*0.9).toInt_()

    /**
     * Recyclerview适配器的item之间的高度
     */
    var recycleViewDividerHeight = ScreenUtil.dip2px(1f)

    /**
     * Recyclerview分割线距离左边的距离
     */
    var recycleViewDividerLeft = ScreenUtil.dip2px(10f)

    /**
     * Recyclerview分割线距离右边的距离
     */
    var recycleViewDividerRight = ScreenUtil.dip2px(10f)

    /**
     * 底部按钮高度
     */
    var buttonHeight = ScreenUtil.dip2px(40f)

    /**
     * 控件各个边角的圆半径
     */
    var radius = ScreenUtil.dip2px(10f)

    /**
     * 设置本地临时存储数据
     *
     * @param c
     * @param setType
     * @param setKey
     * @param setValue
     */
    fun setPreferences(
        c: Context, setType: String, setKey: String,
        setValue: String
    ) {

        val editor = c.getSharedPreferences(
            setType,
            Activity.MODE_PRIVATE
        ).edit()
        editor.putString(setKey, setValue)
        editor.apply()
    }

    fun getPreferences(
        c: Context, getType: String,
        getKey: String, defValue: String
    ): String {
        var getValue = ""

        val preferences = c.getSharedPreferences(
            getType,
            Activity.MODE_PRIVATE
        )
        getValue = preferences.getString(getKey, defValue)?:defValue

        return getValue
    }
}