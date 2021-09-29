import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object Versions {
    const val kotlin = "1.4.20"
}

object PluginVersions {
    const val gradle_test_logger = "3.0.0"
    const val ktlint = "10.1.0"
    const val gradle_plugin_publish = "0.15.0"
}

object PluginConstants {
    const val artifactId = "gradle-commit"
    const val description = "Gradle plugin which helps to commit & push changes to Git repository"
    const val displayName = "Gradle Git Commit Plugin"
    const val groupId = "nl.acierto.gradle.plugins"
    const val implementationClass = "nl.acierto.gradle.plugins.GradleCommitPlugin"
    const val pluginId = "nl.acierto.gradle-commit"
    const val repositoryUrl = "https://github.com/acierto/gradle-commit"

    fun getVersion(): String {
        return "0.0.1-${LocalDateTime.now().format(DateTimeFormatter.ofPattern("Mdd.Hmm"))}"
    }
}
