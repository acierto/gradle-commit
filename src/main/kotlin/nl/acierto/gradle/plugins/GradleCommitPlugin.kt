package nl.acierto.gradle.plugins

import nl.acierto.gradle.plugins.extensions.GradleCommitExtensions
import nl.acierto.gradle.plugins.tasks.GradleCommitTask
import org.gradle.api.GradleException
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.util.GradleVersion

const val EXTENSION_NAME = "gradleCommit"
const val TASK_NAME = "commitChanges"

open class GradleCommitPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.checkMinimalSupportedGradleVersion()

        val extension = project.extensions.create(
            EXTENSION_NAME,
            GradleCommitExtensions::class.java,
            project
        )

        project.tasks.register(TASK_NAME, GradleCommitTask::class.java) {
            it.branchName.set(extension.branchName)

            val propName = "gitMessage"
            if (project.hasProperty(propName)) {
                it.message.set(project.property(propName).toString())
            }
        }
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
