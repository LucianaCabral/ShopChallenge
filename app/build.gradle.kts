plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlinParcelize)
    kotlin("kapt")
}

apply("$rootDir/plugins/android-build.gradle")

android {
    namespace = "br.leeloo.shopchallenge"
}

dependencies {

}