plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.hilt)
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
    kotlin("kapt")
}

android {
    namespace = "com.agonlabs.nefesal"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.agonlabs.nefesal"
        minSdk = 24
        targetSdk = 34
        versionCode = 4
        versionName = "1.0.1"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    signingConfigs {
        create("release") {
            storeFile = file(rootProject.file(project.findProperty("KEYSTORE_FILE") as? String ?: error("Missing KEYSTORE_FILE")))
            storePassword = project.findProperty("KEYSTORE_PASSWORD") as? String ?: error("Missing KEYSTORE_PASSWORD")
            keyAlias = project.findProperty("KEY_ALIAS") as? String ?: error("Missing KEY_ALIAS")
            keyPassword = project.findProperty("KEY_PASSWORD") as? String ?: error("Missing KEY_PASSWORD")
        }
    }

    buildTypes {
        debug {
            isDebuggable = true
            isMinifyEnabled = false
            isShrinkResources = false
            buildConfigField("boolean","IS_DEBUG","true")
        }
        release {
            isDebuggable = false
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName(name)
            buildConfigField("boolean","IS_DEBUG", "false")
        }
    }



    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.firebase.common.ktx)
    implementation(libs.firebase.crashlytics.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Navigation
    implementation("androidx.navigation:navigation-compose:2.7.7")
    
    // Hilt
    implementation("com.google.dagger:hilt-android:2.50")
    kapt("com.google.dagger:hilt-android-compiler:2.50")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

    // Lifecycle
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.7.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")

    // Room
    val roomVersion = "2.6.1"
    implementation("androidx.room:room-runtime:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")
    kapt("androidx.room:room-compiler:$roomVersion")

    // Data store
    implementation("androidx.datastore:datastore-preferences:1.0.0")

    // Google Fonts
    implementation("androidx.compose.ui:ui-text-google-fonts:1.7.7")

    implementation(platform("com.google.firebase:firebase-bom:33.10.0"))
}

kapt {
    correctErrorTypes = true
}