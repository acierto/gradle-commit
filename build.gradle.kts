plugins {
    `java-gradle-plugin`
    kotlin("jvm") version (Versions.kotlin)

    id("idea")
    id("java-gradle-plugin")
    id("maven-publish")
    id("com.gradle.plugin-publish") version (PluginVersions.gradle_plugin_publish)
    id("org.jlleitschuh.gradle.ktlint") version (PluginVersions.ktlint)
    id("com.adarshr.test-logger") version (PluginVersions.gradle_test_logger)
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation(gradleKotlinDsl())
    implementation("org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}")
    implementation("org.jetbrains.kotlin:kotlin-allopen:${Versions.kotlin}")
}

group = properties["groupId"] as String
version = properties["version"] as String

gradlePlugin {
    plugins {
        create("gradleCommit") {
            id = "nl.acierto"
            implementationClass = "nl.acierto.GradleCommitPlugin"
        }
    }
}

pluginBundle {
    vcsUrl = "https://github.com/acierto/gradle-commit"
    website = vcsUrl
    description = "Gradle plugin which helps to commit & push changes to Git repository"
    tags = listOf("kotlin", "gradle", "commit")

    (plugins) {
        "gradleCommit" {
            displayName = "Gradle Git Commit Plugin"
            version = "0.0.1"
        }
    }
}
