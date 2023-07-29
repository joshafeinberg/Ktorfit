plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    alias(libs.plugins.kspPlugin)
}
apply(plugin = "de.jensklingenberg.ktorfit")

configure<de.jensklingenberg.ktorfit.gradle.KtorfitGradleConfiguration> {
    enabled = true
    version = libs.versions.ktorfit.asProvider().get()
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(projects.ktorfitLibCommon)
    implementation(projects.sandbox2)
    ksp(projects.ktorfitKsp)
}