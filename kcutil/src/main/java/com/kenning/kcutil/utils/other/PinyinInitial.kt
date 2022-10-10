//package com.kenning.kcutil.utils.other
//
//import net.sourceforge.pinyin4j.PinyinHelper
//import com.kenning.kcutil.utils.other.PinyinInitial
//import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat
//import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType
//import net.sourceforge.pinyin4j.format.HanyuPinyinToneType
//import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType
//import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination
//import java.lang.StringBuilder
//
//object PinyinInitial {
//    /**
//     * 提取每个汉字的首字母
//     *
//     * @param str
//     * @return String
//     */
//    fun getPinYinHeadChar(str: String): String {
//        val convert = StringBuilder()
//        for (j in 0 until str.length) {
//            val word = str[j]
//            // 提取汉字的首字母
//            val pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word)
//            if (pinyinArray != null) {
//                convert.append(pinyinArray[0][0])
//            } else {
//                convert.append(word)
//            }
//        }
//        return convert.toString()
//    }
//
//    /**将字符串转换成大写首字母 */
//    fun GetFristPinyin(strChinese: String): String {
//        val Frist = StringBuilder()
//        for (i in 0 until strChinese.length) {
//            val str = strChinese[i]
//            Frist.append(GetFristUpperCase(str))
//        }
//        return Frist.toString()
//    }
//
//    /**单个字符转换成拼音的方法 */
//    private fun GetFristUpperCase(str: Char): String {
//        var PyUpper = str.toString()
//        val format = HanyuPinyinOutputFormat()
//
//        // UPPERCASE：大写  (ZHONG)
//        // LOWERCASE：小写  (zhong)
//        format.caseType = HanyuPinyinCaseType.UPPERCASE
//
//        // WITHOUT_TONE：无音标  (zhong)
//        // WITH_TONE_NUMBER：1-4数字表示英标  (zhong4)
//        // WITH_TONE_MARK：直接用音标符（必须WITH_U_UNICODE否则异常）  (zhòng)
//        format.toneType = HanyuPinyinToneType.WITHOUT_TONE
//
//        // WITH_V：用v表示ü  (nv)
//        // WITH_U_AND_COLON：用"u:"表示ü  (nu:)
//        // WITH_U_UNICODE：直接用ü (nü)
//        format.vCharType = HanyuPinyinVCharType.WITH_U_UNICODE
//        try {
//            val pinyin = PinyinHelper.toHanyuPinyinStringArray(str, format)
//            if (pinyin != null) {
//                PyUpper = pinyin[0].toString()
//                PyUpper = PyUpper.substring(0, 1)
//            }
//        } catch (e: BadHanyuPinyinOutputFormatCombination) {
//            e.printStackTrace()
//        }
//        return PyUpper.trim { it <= ' ' }
//    }
//}