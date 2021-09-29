package nl.acierto.gradle.plugins.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.options.Option
import java.io.BufferedReader
import java.io.InputStreamReader

abstract class GradleCommitTask : DefaultTask() {

    @get:Input
    @get:Option(option = "message", description = "A message to be printed in the Git message")
    @get:Optional
    abstract val message: Property<String>

    @get:Input
    @get:Option(option = "branchName", description = "A branch name where this message going to be pushed")
    @get:Optional
    abstract val branchName: Property<String>

    @TaskAction
    fun run() {
        val process: Process = Runtime.getRuntime().exec("echo branchName = $branchName, message = $message")

        val stdInput = BufferedReader(InputStreamReader(process.getInputStream()))
        val stdError = BufferedReader(InputStreamReader(process.getErrorStream()))

        var s: String?
        while (stdInput.readLine().also { s = it } != null) {
            project.logger.lifecycle(s)
        }

        while (stdError.readLine().also { s = it } != null) {
            project.logger.lifecycle(s)
        }
    }
}
