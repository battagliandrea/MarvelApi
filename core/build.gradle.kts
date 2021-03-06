import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id(GradlePluginId.ANDROID_LIBRARY)
    id(GradlePluginId.KOTLIN_ANDROID)
    id(GradlePluginId.KOTLIN_ANDROID_EXTENSIONS)
    id(GradlePluginId.KOTLIN_KAPT)
}

android {
    compileSdkVersion(AndroidConfig.COMPILE_SDK_VERSION)

    defaultConfig {
        minSdkVersion(AndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(AndroidConfig.TARGET_SDK_VERSION)

        versionCode = AndroidConfig.VERSION_CODE
        versionName = AndroidConfig.VERSION_NAME
    }

    buildTypes {

        val privateKey: String = gradleLocalProperties(rootDir).getProperty("marvelapi_private_key")
        val publicKey: String = gradleLocalProperties(rootDir).getProperty("marvelapi_public_key")

        getByName(BuildType.RELEASE) {
            isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
            proguardFiles("proguard-android.txt", "proguard-rules.pro")

            buildConfigField("String", "baseUrl", "\"https://gateway.marvel.com:443/v1/public/\"")
            buildConfigField("String", "apiPrivateKey", privateKey)
            buildConfigField("String", "apiPublicKey", publicKey)
        }

        getByName(BuildType.DEBUG) {
            isMinifyEnabled = BuildTypeDebug.isMinifyEnabled

            buildConfigField("String", "baseUrl", "\"https://gateway.marvel.com:443/v1/public/\"")
            buildConfigField("String", "apiPrivateKey", privateKey)
            buildConfigField("String", "apiPublicKey", publicKey)
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {
    api(LibraryDependency.KOTLIN)
    api(LibraryDependency.KOTLIN_REFLECT)

    api(LibraryDependency.COROUTINES_CORE)
    api(LibraryDependency.COROUTINES_ANDROID)

    api(LibraryDependency.APP_COMPAT)
    api(LibraryDependency.CORE_KTX)
    api(LibraryDependency.FRAGMENT_KTX)
    api(LibraryDependency.LIFECYCLE_EXTENSIONS)
    api(LibraryDependency.LIFECYCLE_VIEW_MODEL_KTX)
    api(LibraryDependency.LIFECYCLE_VIEW_MODEL_SAVED_STATE)

    api(LibraryDependency.OK_HTTP)
    api(LibraryDependency.OK_HTTP_MOCK)
    api(LibraryDependency.OK_HTTP_LOGGING)

    api(LibraryDependency.RETROFIT)
    api(LibraryDependency.RETROFIT_GSON)
    api(LibraryDependency.RETROFIT_MOCK)

    api(LibraryDependency.GSON)

    implementation(LibraryDependency.DAGGER)
    kapt(LibraryDependency.DAGGER_COMPILER)
    kapt(LibraryDependency.DAGGER_PROCESSOR)
}
