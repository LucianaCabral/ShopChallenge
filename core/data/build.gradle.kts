plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
}

apply("$rootDir/plugins/android-build.gradle")

android {
    namespace = "br.leeloo.shopchallenge.core.data"
}

dependencies {
  }