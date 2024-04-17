import java.io.File
import java.io.FileInputStream
import java.util.*

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.sans.poi"
    compileSdk = 33

    val prop = Properties().apply {
        load(FileInputStream(File(rootProject.rootDir, "local.properties")))
    }

    defaultConfig {
        applicationId = "com.sans.poi"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String","API_KEY", prop.getProperty("API_KEY"))
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
        viewBinding = true
        buildConfig = true
    }
}

dependencies {

    implementation("com.google.android.gms:play-services-location:21.2.0")
    val hilt_version = "2.48"
    val retrofit_version = "2.11.0"
    val glide_version = "4.14.2"

    implementation("androidx.core:core-ktx:1.8.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //Hilt
    implementation("com.google.dagger:hilt-android:$hilt_version")
    kapt("com.google.dagger:hilt-android-compiler:$hilt_version")

    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:$retrofit_version")
    implementation("com.squareup.retrofit2:converter-gson:$retrofit_version")

    //Gson
    implementation("com.google.code.gson:gson:2.10.1")

    //Glide
    implementation("com.github.bumptech.glide:glide:$glide_version")
    implementation("com.github.bumptech.glide:okhttp3-integration:$glide_version")
    kapt("com.github.bumptech.glide:compiler:$glide_version")

    //Okhttp
    // define a BOM and its version
    implementation(platform("com.squareup.okhttp3:okhttp-bom:4.12.0"))
    // define any required OkHttp artifacts without version
    implementation("com.squareup.okhttp3:okhttp")
    implementation("com.squareup.okhttp3:logging-interceptor")

    //Pagination
    implementation("androidx.paging:paging-runtime:3.2.1")

    //ViewModel
    implementation("androidx.fragment:fragment-ktx:1.6.2")

    //Live Event
    implementation("com.github.hadilq:live-event:1.3.0")
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}