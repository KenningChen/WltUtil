package com.kenning.kcutil.utils.other

import android.os.Handler
import android.os.Message
import android.widget.Toast
import com.kenning.kcutil.KCUtil
import java.lang.reflect.Field

object ToastUtil {
    private var toast: Toast? = null
    private var sFieldTN: Field? = null
    private var sFieldTNHandler: Field? = null

    init {
        try {
            sFieldTN = Toast::class.java.getDeclaredField("mTN")
            sFieldTN?.isAccessible = true
            sFieldTNHandler = sFieldTN?.type?.getDeclaredField("mHandler")
            sFieldTNHandler?.isAccessible = true
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun hook(toast: Toast) {
        try {
            val tn = sFieldTN!![toast]
            val preHandler: Handler = sFieldTNHandler!![tn] as Handler
            sFieldTNHandler!![tn] = SafelyHandlerWrapper(preHandler)
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    private class SafelyHandlerWrapper constructor(private val impl: Handler) :
        Handler() {
        override fun dispatchMessage(msg: Message) {
            try {
                super.dispatchMessage(msg)
            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }
        }

        override fun handleMessage(msg: Message) {
            impl.handleMessage(msg)
        }
    }

    fun show(msg: String) {
//        Toast.makeText(App.instance, msg, Toast.LENGTH_SHORT).show()
        try {
            if (toast == null) {
                toast = Toast.makeText(KCUtil.application, msg, Toast.LENGTH_SHORT)
            } else {
                toast!!.setText(msg)
            }
            hook(toast!!)
            toast!!.show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}