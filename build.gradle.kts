plugins {
    `java-gradle-plugin`
    `maven-publish`
    kotlin("jvm") version (Versions.kotlin)

    id("idea")
    id("com.gradle.plugin-publish") version (PluginVersions.gradle_plugin_publish)
    id("org.jlleitschuh.gradle.ktlint") version (PluginVersions.ktlint)
    id("com.adarshr.test-logger") version (PluginVersions.gradle_test_logger)
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation(gradleKotlinDsl())
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}")
    implementation("org.jetbrains.kotlin:kotlin-allopen:${Versions.kotlin}")
}

group = PluginConstants.groupId
version = PluginConstants.version

if (!project.hasProperty("local")) {
    gradlePlugin {
        plugins {
            create("gradleCommit") {
                id = PluginConstants.pluginId
                description = PluginConstants.description
                displayName = PluginConstants.displayName
                implementationClass = PluginConstants.implementationClass
            }
        }
    }

    pluginBundle {
        vcsUrl = PluginConstants.repositoryUrl
        website = PluginConstants.repositoryUrl
        tags = listOf("kotlin", "gradle", "commit")

        (plugins) {
            "gradleCommit" {
                id = PluginConstants.pluginId
                displayName = PluginConstants.displayName
                version = PluginConstants.version
            }
        }
    }
} else {
    project.afterEvaluate {
        publishing {
            publications {
                create<MavenPublication>("mavenPublish") {
                    groupId = PluginConstants.groupId
                    artifactId = PluginConstants.artifactId
                    version = PluginConstants.version

                    pom {
                        name.set(PluginConstants.displayName)
                        description.set(PluginConstants.description)
                        inceptionYear.set("2020")
                        url.set(PluginConstants.repositoryUrl)
                        developers {
                            developer {
                                name.set("Bogdan Nechyporenko")
                                id.set("acierto")
                            }
                        }
                        licenses {
                            license {
                                name.set("MIT")
                                url.set("https://opensource.org/licenses/MIT")
                            }
                        }
                    }
                }
            }
        }
    }
}
