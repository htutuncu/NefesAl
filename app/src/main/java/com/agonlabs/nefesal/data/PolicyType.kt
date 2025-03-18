package com.agonlabs.nefesal.data

import androidx.compose.runtime.Composable
import com.agonlabs.nefesal.R
import com.agonlabs.nefesal.util.localizedStringResource

enum class PolicyType(val type: Int) {
    PRIVACY_POLICY(1),
    TERMS_OF_USE(2);

    fun getFileName() : String {
        return when (this) {
            PRIVACY_POLICY -> "privacy_policy.html"
            TERMS_OF_USE -> "terms_of_use.html"
        }
    }

    @Composable
    fun getTitle() : String {
        return when (this) {
            PRIVACY_POLICY -> localizedStringResource(id = R.string.privacy_policy)
            TERMS_OF_USE -> localizedStringResource(id = R.string.terms_of_use)
        }
    }
}