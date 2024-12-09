package com.akapp.shinrai_v2

import android.graphics.drawable.Drawable

data class MbtiData(
    //MBTIタイプに必要な要素のデータ
    //2024/12/09の現時点ではdescription
    //までは要らないためテキスト化する
    val imageRes: Int,
    val frameDrawableRes: Int,
    val displayName: String,
//    val description: String
)
