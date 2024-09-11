// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
//    alias(libs.plugins.android.application) apply false
//    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.jetbrains.kotlin.jvm) apply false
    id("maven-publish")
}

//
//repositories {
//    mavenCentral()
//}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.mangofp"
            artifactId = "demoji-kotlin-2"
            version = "1.0.0"
            //afterEvaluate { artifact(tasks.getByName("bundleReleaseAar"))}
        }
    }
}