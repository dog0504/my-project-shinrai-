package com.akapp.shinrai_v2

object MbtiResourceMap {
    private val MbtiResourceMap: Map<String, MbtiData> = mapOf(
        "INTJ" to MbtiData(
            imageRes = R.drawable.intj_icon,
            frameDrawableRes = R.drawable.mbti_layout,
            displayName = "INTJ"
        ),
        "INTP" to MbtiData(
            imageRes = R.drawable.intp_icon,
            frameDrawableRes = R.drawable.mbti_layout,
            displayName = "INTP"
        ),
        "ENTJ" to MbtiData(
            imageRes = R.drawable.entj_icon,
            frameDrawableRes = R.drawable.mbti_layout,
            displayName = "ENTJ"
        ),
        "ENTP" to MbtiData(
            imageRes = R.drawable.entp_icon,
            frameDrawableRes = R.drawable.mbti_layout,
            displayName = "ENTP"
        ),
        "INFJ" to MbtiData(
            imageRes = R.drawable.infj_icon,
            frameDrawableRes = R.drawable.mbti_layout,
            displayName = "INFJ"
        ),
        "INFP" to MbtiData(
            imageRes = R.drawable.infp_icon,
            frameDrawableRes = R.drawable.mbti_layout,
            displayName = "INFP"
        ),
        "ENFJ" to MbtiData(
            imageRes = R.drawable.enfj_icon,
            frameDrawableRes = R.drawable.mbti_layout,
            displayName = "ENFJ"
        ),
        "ENFP" to MbtiData(
            imageRes = R.drawable.enfp_icon,
            frameDrawableRes = R.drawable.mbti_layout,
            displayName = "ENFP"
        ),
        "ISTJ" to MbtiData(
            imageRes = R.drawable.istj_icon,
            frameDrawableRes = R.drawable.mbti_layout,
            displayName = "ISTJ"
        ),
        "ISFJ" to MbtiData(
            imageRes = R.drawable.isfj_icon,
            frameDrawableRes = R.drawable.mbti_layout,
            displayName = "ISFJ"
        ),
        "ESTJ" to MbtiData(
            imageRes = R.drawable.estj_icon,
            frameDrawableRes = R.drawable.mbti_layout,
            displayName = "ESTJ"
        ),
        "ESFJ" to MbtiData(
            imageRes = R.drawable.esfj_icon,
            frameDrawableRes = R.drawable.mbti_layout,
            displayName = "ESFJ"
        ),
        "ISTP" to MbtiData(
            imageRes = R.drawable.istp_icon,
            frameDrawableRes = R.drawable.mbti_layout,
            displayName = "ISTP"
        ),
        "ISFP" to MbtiData(
            imageRes = R.drawable.isfp_icon,
            frameDrawableRes = R.drawable.mbti_layout,
            displayName = "ISFP"
        ),
        "ESTP" to MbtiData(
            imageRes = R.drawable.estp_icon,
            frameDrawableRes = R.drawable.mbti_layout,
            displayName = "ESTP"
        ),
        "ESFP" to MbtiData(
            imageRes = R.drawable.esfp_icon,
            frameDrawableRes = R.drawable.mbti_layout,
            displayName = "ESFP"
        )
    )

    //　[]演算子を使うためのoperator関数
    operator fun get(key:String): MbtiData?{
        return MbtiResourceMap[key]
    }
}