package com.kenning.kcutil

import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.lifecycleScope
import com.kenning.base.BaseActivity
import com.kenning.kcutil.databinding.ActivityMainBinding
import com.kenning.kcutil.utils.date.DateExtendUtil
import com.kenning.kcutil.utils.date.Date_Format
import com.kenning.kcutil.utils.date.formatBy
import com.kenning.kcutil.utils.datepicker.IPickerListener
import com.kenning.kcutil.utils.dialog.easydialog.EasyDialog
import com.kenning.kcutil.utils.dialog.fragmentdialog.BaseFragmentDialog
import com.kenning.kcutil.utils.dialog.fragmentdialog.DialogFragmentButtonMode
import com.kenning.kcutil.utils.other.PermissionGroup
import com.kenning.kcutil.utils.other.ToastUtil
import com.kenning.kcutil.utils.other.setHook
import com.kenning.kcutil.utils.tts.TTSUtil
import kotlinx.android.synthetic.main.view_test_dialog.view.view1
import kotlinx.android.synthetic.main.view_test_dialog.view.view2
import kotlinx.coroutines.launch
import java.util.Date

class MainActivity : BaseActivity(), IPickerListener {

    //    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val da = DateExtendUtil.getBalanceDateByDay(
            Date().formatBy(Date_Format.YMD),
            Date_Format.YMD,
            5
        )
        Log.e("kenning", da)
//        supportFragmentManager.beginTransaction().add(R.id.fcvMain, FirstFragment(),"first").commit()
        loadRootFragment(binding.fcvMain.id, FirstFragment())

        binding.fab.setOnClickListener { view ->
            TTSUtil.getInstance()?.playText("拣货完成")
//            lifecycleScope.launch {
//
//                val view_body = LayoutInflater.from(this@MainActivity).inflate(
//                    R.layout.view_test_dialog, null
//                )
//                view_body.view1.setOnClickListener { ToastUtil.show("click view1") }
//                view_body.view2.setOnClickListener { ToastUtil.show("click view2") }
//
//
//                val result = BaseFragmentDialog(view_body)
//                    .setTitle("测试")
//                    .setButtonMode(
//                        DialogFragmentButtonMode("hh"),
//                        DialogFragmentButtonMode("YY")
//                    )
//                    .showAsSuspend(
//                        supportFragmentManager,
//                        BaseFragmentDialog::class.java.simpleName
//                    )
//                if (result.toString() == "YY"){
//                    ToastUtil.show("click yy")
//                }else{
//                    ToastUtil.show("click other")
//                }
//            }
        }
        binding.tagswitch.setOnSwitchSuspendListener/*({
            val result = EasyDialog(this@MainActivity).setContentMsg("测试")
                .buildAsSuspend()
            true
        }) */{
//            ToastUtil.show("成功了")
//
//            TTSUtil.getInstance()?.playText("拣货货位A100-1")
            TTSUtil.checkTTS(this)
        }
        binding.tagswitch.setHook(
            PermissionGroup.PHONE.name,
            "没有电话权限,无法执行该功能,请先去设置权限"
        )
    }

    override fun closeAct() {
        TODO("Not yet implemented")
    }

    override fun getBeforeData() {
        TODO("Not yet implemented")
    }

    override fun defaultData() {
        TODO("Not yet implemented")
    }

    override fun dealData() {
        TODO("Not yet implemented")
    }

    override fun initView() {
        TODO("Not yet implemented")
    }

    override fun bindClickEvent() {
        TODO("Not yet implemented")
    }

    override fun reLoadApp() {
        TODO("Not yet implemented")
    }

    override fun onDismissPicker() {

    }

    override fun onDateChange(requestcode: Int, start: String, end: String): Boolean {
        binding.tag11.text = start
        return true
    }

}