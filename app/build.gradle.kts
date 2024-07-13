plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.googleGmsGoogleServices)
}

android {
    namespace = "com.example.voyageverse"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.voyageverse"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"



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
    buildToolsVersion = "34.0.0"
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.firebase.auth)
    implementation(libs.firebase.database)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation("com.airbnb.android:lottie:4.0.0")
    implementation("com.google.android.gms:play-services-maps:18.0.1")


}


