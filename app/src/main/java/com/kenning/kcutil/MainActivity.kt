package com.kenning.kcutil

import android.content.Intent
import android.os.Bundle
import com.kenning.base.BaseActivity
import com.kenning.kcutil.databinding.ActivityMainBinding
import com.kenning.kcutil.utils.date.DateExtendUtil
import com.kenning.kcutil.utils.datepicker.DatePickerBuilder
import com.kenning.kcutil.utils.datepicker.IPickerListener
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
            startActivity(Intent(this, ReduxTestAct::class.java))
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