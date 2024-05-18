plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.kotlinAndroidKsp)
    alias(libs.plugins.hiltAndroid)
}

android {
    namespace = "parniyan.mahmoudroid.compose"
    compileSdk = 34

    defaultConfig {
        applicationId = "parniyan.mahmoudroid.compose"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.8"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "/META-INF/gradle/incremental.annotation.processors"
        }
    }
}

dependencies {
    implementation(project(":base"))
    implementation(project(":network"))
    implementation(libs.android.core.splashscreen)
    implementation(libs.android.datastore.preferences)
    implementation(libs.android.datastore.preferences)

    implementation(libs.bundles.compose)
    implementation(libs.compose.accompanist.navigation)
    implementation(libs.compose.navigation.hilt)
    implementation(libs.androidx.appcompat)

    debugImplementation(libs.compose.ui.tooling)

    implementation(libs.ktor.client.core)


    implementation(libs.hilt)
    ksp(libs.hilt.compiler)
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)

    //worker
    implementation(libs.androidx.work.runtime.ktx)
    implementation(libs.android.work.hilt)
   // ksp(libs.android.work.hilt.compiler)
    implementation(libs.compose.material3)
}