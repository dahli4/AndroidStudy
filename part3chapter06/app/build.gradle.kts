plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.daggerHiltAndroid)
    alias(libs.plugins.jetbrainKotlinKapt)
}

android {
    namespace = "com.example.part3.chapter06"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.part3.chapter06"
        minSdk = 27
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
        dataBinding = true
    }
}

dependencies {
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    androidTestImplementation(libs.hilt.android.test)
    androidTestAnnotationProcessor(libs.hilt.compiler)

    testImplementation(libs.hilt.android.test)
    testAnnotationProcessor(libs.hilt.compiler)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.ktx)
    implementation(libs.coil)
    implementation(libs.okhttp)
    implementation(libs.retrofit)
    implementation(libs.gson)
    implementation(libs.coroutines)
    implementation(libs.paging)
}

kapt {
    correctErrorTypes = true
}