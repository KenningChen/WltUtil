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
            lifecycleScope.launch {

                val view_body = LayoutInflater.from(this@MainActivity).inflate(
                    R.layout.view_test_dialog, null
                )
                view_body.view1.setOnClickListener { ToastUtil.show("click view1") }
                view_body.view2.setOnClickListener { ToastUtil.show("click view2") }


                val result = BaseFragmentDialog(view_body)
                    .setTitle("测试")
                    .setButtonMode(
                        DialogFragmentButtonMode("hh"),
                        DialogFragmentButtonMode("YY")
                    )
                    .showAsSuspend(
                        supportFragmentManager,
                        BaseFragmentDialog::class.java.simpleName
                    )
                if (result.toString() == "YY"){
                    ToastUtil.show("click yy")
                }else{
                    ToastUtil.show("click other")
                }
            }
        }
        binding.tagswitch.setOnSwitchSuspendListener/*({
            val result = EasyDialog(this@MainActivity).setContentMsg("测试")
                .buildAsSuspend()
            true
        }) */{
            ToastUtil.show("成功了")

            TTSUtil.getInstance()?.playText("拣货货位A100-1")
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

//
fun CMApiWarnToast(context: Activity/*, clazz: Class<*>*/): SpannableStringBuilder {
    val mMsg2 =
        "检测到您对接的版本为财贸21.5及以上，请确保已填写管家婆【应用中心】-【移动管理】-【服务器设置】中的管家婆地址信息。否则，APP功能将无法正常使用。\n点击查看设置说明"

    val style = SpannableStringBuilder()
    style.append(mMsg2)

    val foregroundColorSpan3 =
        ForegroundColorSpan(
            ResourcesCompat.getColor(
                context.resources,
                R.color.purple_200, null
            )
        )
    style.setSpan(
        foregroundColorSpan3,
        0,
        mMsg2.length,
        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
    )

    val agreement = "点击查看设置说明"
//    // 设置部分文字点击事件
//    val clickableSpan: ClickableSpan = object : ClickableSpan() {
//        override fun onClick(widget: View) {
////                if (clazz != null) {
//            val intent = Intent(context, clazz)
//            val bundle = Bundle()
//            bundle.putString(
//                "url",
//                "http://help.wltrj.com/wltty/App/Api/财贸API对接说明.html"
//            )
//            bundle.putString("name", "财贸API对接说明")
//            intent.putExtras(bundle)
//            context.startActivity(intent)
////                }
//        }
//    }
//    style.setSpan(
//        clickableSpan,
//        mMsg2.indexOf(agreement),
//        mMsg2.indexOf(agreement) + agreement.length,
//        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//    )

    val foregroundColorSpan = ForegroundColorSpan(
        ResourcesCompat.getColor(
            context.resources,
            R.color.teal_200,
            null
        )
    )
    style.setSpan(
        foregroundColorSpan,
        mMsg2.indexOf(agreement),
        mMsg2.indexOf(agreement) + agreement.length,
        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
    )

    return style
}