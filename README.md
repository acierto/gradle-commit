
# gradle-commit
Gradle plugin which helps to commit &amp; push changes to Git repository

## Usage

```groovy
plugins {
    id: 'nl.acierto.gradle-commit'
}
```

Available parameters

|Name|Type|Default Value|Description|
| :---: | :---: | :---: | :---: |
|gitBranchName|Optional|master|A branch name where this message going to be pushed.|
|gitFileContent|Optional|-A|In case of specified, command `git add 'fileContent'` will be executed.|
|gitMessage|Optional|Blank commit message.|A message to be printed in the Git message.|

## Development

Publish to local maven repository: `./publish_to_local_maven.sh`

Adding the next in your project to use a local version: 

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

```

Run command like this to test it: `./gradlew commitChanges -PgitMessage="my message" -PgitFileContent="docs/*" -PgitBranchName="master"`

