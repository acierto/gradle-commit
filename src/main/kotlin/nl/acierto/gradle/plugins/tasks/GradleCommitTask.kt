package nl.acierto.gradle.plugins.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class GradleCommitTask : DefaultTask() {

    @TaskAction
    fun run() {
        Runtime.getRuntime().exec("echo 1")
    }
}
