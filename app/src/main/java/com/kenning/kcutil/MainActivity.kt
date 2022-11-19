package com.kenning.kcutil

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.view.View
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.snackbar.Snackbar
import com.kenning.base.BaseActivity
import com.kenning.kcutil.databinding.ActivityMainBinding
import com.kenning.kcutil.utils.date.DateExtendUtil
import com.kenning.kcutil.utils.datepicker.DatePickerBuilder
import com.kenning.kcutil.utils.datepicker.IPickerListener
import com.kenning.kcutil.utils.dialog.easydialog.ButtonMode
import com.kenning.kcutil.utils.dialog.easydialog.EasyDialog
import com.reduxdemo.ReduxTestAct

class MainActivity : BaseActivity(), IPickerListener {

//    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        supportFragmentManager.beginTransaction().add(R.id.fcvMain, FirstFragment(),"first").commit()
        loadRootFragment(binding.fcvMain.id,FirstFragment())

        binding.fab.setOnClickListener { view ->
//            EasyDialog(this).setTitle("地对地导弹地对地导弹的地对地导弹地对地导弹的111地对地导弹地对地导弹的地对地导弹地对地导弹的111")
//                .setArray(arrayOf("1","2","3","4","5","6","7",
//                "8")){
//                            Snackbar.make(view, "$it", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//            }
//                .build()
//            DatePickerBuilder(this).setBeginDate(DateExtendUtil.getCurrentDate())
////                .setEndDate(DateExtendUtil.getCurrentDate())
//                .setSingle(true)
//                .setRequestCode(111)
////                .setLoaction(PickerControl.ShowLocation.BOTTOM)
//                .start(R.id.fcvMain)
//            startActivity(Intent(this, ReduxTestAct::class.java))
            EasyDialog(this).setContentMsg(CMApiWarnToast(this))
                .setButtonMode(
                    ButtonMode("测试"),
                    ButtonMode("测试"),
                    ButtonMode("测试")
                ).setBottomOption(1).setDialogReact(75,heightPer=90)
                .build()
//            EasyDialog(this).setTitle("地对地导弹地对地导弹的地对地导弹地对地导弹的111地对地导弹地对地导弹的地对地导弹地对地导弹的111")
//                .setArray(arrayOf("1","2","3","4","5","6","7",
//                    "8","1","2","3","4","5","6","7",
//                    "8")){
//                    Snackbar.make(view, "$it", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show()
//                }.setButtonMode(
//                    ButtonMode("测试"),
//                    ButtonMode("测试"),
//                    ButtonMode("测试")
//                ).setBottomOption(1).setDialogReact(90,heightPer=90)
//                .build()
        }
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

    override fun onDateChange(requestcode: Int, start: String, end: String) {
        binding.tag11.text = start
    }

}
//
fun CMApiWarnToast(context: Activity/*, clazz: Class<*>*/): SpannableStringBuilder {
    val mMsg2 = "检测到您对接的版本为财贸21.5及以上，请确保已填写管家婆【应用中心】-【移动管理】-【服务器设置】中的管家婆地址信息。否则，APP功能将无法正常使用。\n点击查看设置说明"

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