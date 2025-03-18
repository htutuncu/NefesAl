package com.agonlabs.nefesal.util

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.agonlabs.nefesal.data.SmokingBenefit
import org.json.JSONObject

@Composable
fun localizedStringResource(id: Int): String {
    val context = LocalContext.current
    val localization = LocalLocalization.current
    
    return context.createConfigurationContext(
        context.resources.configuration.apply {
            setLocale(localization.locale)
        }
    ).getString(id)
}

@Composable
fun loadLocalizedSmokingBenefits(context: Context): List<SmokingBenefit> {
    val localization = LocalLocalization.current
    var locale = localization.locale.language
    if (locale != "tr" && locale != "en") {
        locale = "en"
    }

    val jsonString = context.assets.open("smoking_benefits.json").bufferedReader().use { it.readText() }

    val jsonObject = JSONObject(jsonString)
    val benefitsJson = jsonObject.getJSONObject("smoking_benefits")
    val benefitsArray = benefitsJson.getJSONArray(locale)

    return List(benefitsArray.length()) { index ->
        val benefitObject = benefitsArray.getJSONObject(index)
        SmokingBenefit(
            time = benefitObject.getInt("time"),
            text = benefitObject.getString("text")
        )
    }
}

