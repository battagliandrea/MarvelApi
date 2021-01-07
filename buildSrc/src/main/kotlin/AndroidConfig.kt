object AndroidConfig {
    const val ID = "com.battagliandrea.marvelapi"

    const val COMPILE_SDK_VERSION = 30
    const val MIN_SDK_VERSION = 23
    const val TARGET_SDK_VERSION = 30
    const val BUILD_TOOLS_VERSION = "30.0.2"

    const val VERSION_CODE = 1
    const val VERSION_NAME = "1.0"

    const val TEST_RUNNER = "android.support.test.runner.AndroidJUnitRunner"
}

interface BuildType {

    companion object {
        const val RELEASE = "release"
        const val DEBUG = "debug"
    }

    val isMinifyEnabled: Boolean
}

object BuildTypeDebug : BuildType {
    override val isMinifyEnabled = false
}

object BuildTypeRelease : BuildType {
    override val isMinifyEnabled = false
}