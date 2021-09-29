package nl.acierto.gradle.plugins

import nl.acierto.gradle.plugins.extensions.GradleCommitExtensions
import org.gradle.api.GradleException
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.util.GradleVersion

open class GradleCommitPlugin : Plugin<Project> {
    internal lateinit var extension: GradleCommitExtensions

    override fun apply(target: Project) {
        target.checkMinimalSupportedGradleVersion()

        extension = target.extensions.create(
            "gradleCommit",
            GradleCommitExtensions::class.java,
            target
        )
    }

    private fun Project.checkMinimalSupportedGradleVersion() {
        if (GradleVersion.version(gradle.gradleVersion) < GradleVersion.version(LOWEST_SUPPORTED_GRADLE_VERSION)) {
            throw GradleException(
                "Current version of plugin supports minimal Gradle version: $LOWEST_SUPPORTED_GRADLE_VERSION"
            )
        }
    }

    companion object {
        const val LOWEST_SUPPORTED_GRADLE_VERSION = "6.9.1"
    }

}
