package com.oozee.stockviewweb.Global.Font

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.annotation.Nullable
import androidx.appcompat.widget.AppCompatTextView
import com.oozee.stockviewweb.R


@SuppressLint("AppCompatCustomView")
class CustomFontTextView : AppCompatTextView {

    constructor(context: Context) : super(context)

    constructor(context: Context, @Nullable attrs: AttributeSet) : super(context, attrs) {
        CustomFont(context, attrs)
    }

    constructor(context: Context, @Nullable attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs,defStyleAttr) {
        CustomFont(context, attrs)
    }

    private fun CustomFont(context: Context, attrs: AttributeSet) {
        val a = context.obtainStyledAttributes(attrs, R.styleable.CustomFontView)
        val customFont = a.getString(R.styleable.CustomFontView_CustomFont)
        CustomTypeFace(customFont)
        a.recycle()
    }

    private fun CustomTypeFace(customFont: String?): Boolean {
        try {
            if (isInEditMode) {

            } else {
                typeface = Typeface.createFromAsset(context.assets, customFont)
            }
        } catch (e: Exception) {
            return false
        }

        return true
    }
}
