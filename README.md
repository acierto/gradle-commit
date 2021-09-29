# gradle-commit
Gradle plugin which helps to commit &amp; push changes to Git repository

## Development

Publish to local maven repository: `./publish_to_local_maven.sh`

Adding the next in your project to use local version: 

```groovy
buildscript {
    repositories {
        mavenLocal()
    }

    dependencies {
        classpath "nl.acierto.gradle.plugins:gradle-commit:VERSION"
    }
}

//...

apply plugin: 'nl.acierto.gradle-commit'

//...

gradleCommit {
    branchName = "mybranch"
}

```

And run command like this to test it: `./gradlew clean commitChanges -PgitMessage="my message"`

