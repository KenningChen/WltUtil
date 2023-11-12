package com.kenning.kcutil.utils.tts

import android.content.Context
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.util.Log
import android.widget.Toast
import com.kenning.kcutil.KCUtil
import com.kenning.kcutil.utils.other.ToastUtil
import java.util.Locale


/**
 *Description :
 *@author : KenningChen
 *Date : 2023/11/11
 */
class TTSUtil() : UtteranceProgressListener() {
    private var mContext: Context? = null
    private var textToSpeech: TextToSpeech? = null // 系统语音播报类
    private var isSuccess = true

    constructor(context: Context) : this() {
        mContext = context.applicationContext
        textToSpeech = TextToSpeech(
            mContext
        ) { i: Int ->
            //系统语音初始化成功
            if (i == TextToSpeech.SUCCESS) {
                val result = textToSpeech!!.setLanguage(Locale.CHINA)
                textToSpeech!!.setPitch(1.0f) // 设置音调，值越大声音越尖（女生），值越小则变成男声,1.0是常规
                textToSpeech!!.setSpeechRate(1.0f) // 播报速度
                textToSpeech!!.setOnUtteranceProgressListener(this@TTSUtil)
                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    //系统不支持中文播报
                    isSuccess = false
                }
            }
        } //百度的播放引擎 "com.baidu.duersdk.opensdk"
    }

    /**
     * @param playText 播报文本内容
     * @param speakEachNumber 文本中的数字内容是否依次读取
     */
    fun playText(playText: String?, speakEachNumber: Boolean = true) {
        if (!isSuccess) {
            ToastUtil.show("系统不支持中文播报，请到用户配置安装三方语音播报")
            return
        }
        if (textToSpeech != null) {
            val newtext = if (speakEachNumber) {
                playText?.replace("-", "杠")
                    ?.replace("1", "一")
                    ?.replace("2", "二")
                    ?.replace("3", "三")
                    ?.replace("4", "四")
                    ?.replace("5", "五")
                    ?.replace("6", "六")
                    ?.replace("7", "七")
                    ?.replace("8", "八")
                    ?.replace("9", "九")
                    ?: kotlin.run { "" }
            } else {
                playText?.replace("-", "杠")
                    ?: kotlin.run { "" }
            }
            textToSpeech!!.speak(newtext, TextToSpeech.QUEUE_ADD, null, null)
        }
    }

    fun stopSpeak() {
        textToSpeech?.stop()
        textToSpeech?.shutdown()
    }

    /**
     * 是否支持中文播报
     */
    fun supportChinese() = isSuccess

    override fun onStart(utteranceId: String?) {}
    override fun onDone(utteranceId: String?) {}
    override fun onError(utteranceId: String?) {}

    companion object {
        private var singleton: TTSUtil? = null
        fun getInstance(): TTSUtil? {
            if (singleton == null) {
                synchronized(TTSUtil::class.java) {
                    if (singleton == null) {
                        singleton = TTSUtil(KCUtil.application!!)
                    }
                }
            }
            return singleton
        }
    }
}
