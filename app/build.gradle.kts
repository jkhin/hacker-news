import constants.implementation
import extensions.*

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("androidx.navigation.safeargs")
    id("kotlin-kapt")
}

android {

    compileSdkVersion(Versions.App.compileSdkVersion)
    buildToolsVersion(Versions.App.buildToolsVersion)


    defaultConfig {
        applicationId = Config.applicationId
        minSdkVersion(Versions.App.minSdkVersion)
        targetSdkVersion(Versions.App.targetSdkVersion)
        versionCode = Versions.App.appVersionCode
        versionName = Versions.App.appVersionName

        testInstrumentationRunner = Config.testInstrumentationRunner
    }

    buildTypes {

        create("develop") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField(
                Config.FieldType.stringType,
                Config.Build.hackerNewsUrlFieldName,
                Config.Build.hackerNewsUrlFieldValue
            )
        }

        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField(
                Config.FieldType.stringType,
                Config.Build.hackerNewsUrlFieldName,
                Config.Build.hackerNewsUrlFieldValue
            )
        }

        getByName("debug") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField(
                Config.FieldType.stringType,
                Config.Build.hackerNewsUrlFieldName,
                Config.Build.hackerNewsUrlFieldValue
            )
        }

    }

    sourceSets {
        sourceSets.getByName("main") {
            java.srcDir("src/main/java")
            java.srcDir("src/main/kotlin")
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
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    kotlinLibs()
    androidLibs()
    koinLibs()
    moshiLibs()
    retrofitLibs()
    okHttpsLibs()
    roomLibs()
    testLibs()
}