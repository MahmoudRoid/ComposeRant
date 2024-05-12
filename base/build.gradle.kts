plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "parniyan.mahmoudroid.compose.base"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.android.datastore.preferences)
    implementation(libs.android.datastore.preferences)
    implementation(libs.compose.navigation.hilt)
    implementation(libs.hilt.android)
    implementation(libs.hilt.compiler)
    implementation(libs.compose.material3)
    implementation(libs.compose.accompanist.navigation)
    implementation(libs.compose.accompanist.pager.indicator)
    //kotlinAndroidKsp(libs.hilt.compiler)
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    implementation(libs.material)
    //ksp(libs.room.compiler)
    //data
    implementation(libs.bundles.ktor)
    implementation(libs.room.runtime)
    //ksp(libs.room.compiler)


    //domain
    implementation(libs.coroutines.core)
    implementation(libs.ktor.client.core)
    implementation(libs.gson)

    //presentation
    implementation(libs.compose.navigation.hilt)
    implementation(libs.compose.navigation)

    implementation(libs.android.datastore.preferences)
}