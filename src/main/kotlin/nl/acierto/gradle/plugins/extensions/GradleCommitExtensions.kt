package nl.acierto.gradle.plugins.extensions

import org.gradle.api.Project
import org.gradle.api.provider.Property

open class GradleCommitExtensions
internal constructor(project: Project) {

    val branchName: Property<String> = project.objects.property(String::class.java)
}
