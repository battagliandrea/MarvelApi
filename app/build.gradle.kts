

plugins {
    id(GradlePluginId.ANDROID_APPLICATION)
    id(GradlePluginId.KOTLIN_ANDROID)
    id(GradlePluginId.KOTLIN_ANDROID_EXTENSIONS)
    id(GradlePluginId.KOTLIN_KAPT)
}

apply {
    from("$rootDir/script/install-git-hooks.gradle")
}

android {
    compileSdkVersion(AndroidConfig.COMPILE_SDK_VERSION)

    defaultConfig {
        applicationId = AndroidConfig.ID
        minSdkVersion(AndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(AndroidConfig.TARGET_SDK_VERSION)
        buildToolsVersion(AndroidConfig.BUILD_TOOLS_VERSION)

        versionCode = AndroidConfig.VERSION_CODE
        versionName = AndroidConfig.VERSION_NAME

        buildConfigField("FEATURE_MODULE_NAMES", getDynamicFeatureModuleNames())
    }

    buildTypes {

        getByName(BuildType.RELEASE) {
            isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
            proguardFiles("proguard-android.txt", "proguard-rules.pro")
        }

        getByName(BuildType.DEBUG) {
            isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }
    }

    dynamicFeatures = ModuleDependency.getDynamicFeatureModules().toMutableSet()

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {
    api(project(ModuleDependency.CORE))

    implementation(LibraryDependency.DAGGER)
    kapt(LibraryDependency.DAGGER_COMPILER)
    kapt(LibraryDependency.DAGGER_PROCESSOR)

    api(LibraryDependency.GLIDE)
    kapt(LibraryDependency.GLIDE_COMPILER)

    api(LibraryDependency.CONSTRAINT_LAYOUT)
    api(LibraryDependency.COORDINATOR_LAYOUT)
    api(LibraryDependency.RECYCLER_VIEW)
    api(LibraryDependency.MATERIAL)

    api(LibraryDependency.NAVIGATION_FRAGMENT_KTX)
    api(LibraryDependency.NAVIGATION_UI_KTX)
    api(LibraryDependency.NAVIGATION_FEATURES)
}

fun getDynamicFeatureModuleNames() = ModuleDependency.getDynamicFeatureModules()
    .map { it.replace(":feature_", "") }
    .toSet()

fun com.android.build.gradle.internal.dsl.DefaultConfig.buildConfigField(
    name: String,
    value: Set<String>
) {
    val strValue = value.joinToString(
        prefix = "{",
        separator = ",",
        postfix = "}",
        transform = { "\"$it\"" }
    )
    buildConfigField("String[]", name, strValue)
}
