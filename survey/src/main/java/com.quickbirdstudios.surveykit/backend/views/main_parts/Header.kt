package com.quickbirdstudios.surveykit.backend.views.main_parts

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.quickbirdstudios.surveykit.R
import com.quickbirdstudios.surveykit.SurveyTheme

// TODO should take [Configuration] in constructor and remove public color setters and getters
class Header @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleRes: Int = 0
) : Toolbar(context, attrs, defStyleRes),
    StyleablePart {

    //region Public API

    var themeColor = Color.RED
        set(value) {
            field = value
        }

    var label: String
        get() = headerLabel.text.toString()
        set(label) {
            headerLabel.text = label
        }

    //endregion

    //region Members

    private val root: View = View.inflate(context, R.layout.layout_header, this)
    private val headerLabel: TextView = root.findViewById(R.id.headerLabel)

    //endregion

    //region Overrides

    override fun style(surveyTheme: SurveyTheme) {
        themeColor = surveyTheme.themeColor
    }

    //endregion

    //region Private API

    // TODO this should probably not be done here
    private fun hideKeyboard() {
        val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(this.windowToken, 0)
    }
    //endregion
}
