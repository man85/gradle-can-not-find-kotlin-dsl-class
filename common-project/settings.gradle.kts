import kotlin.io.path.Path

rootProject.name = "common-project"

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
    }
}

pluginManagement {
    repositories {
        mavenCentral()
    }
    plugins {
        kotlin("jvm") version "1.9.24"
    }
}

include(":platform")
project(":platform").projectDir = Path(settingsDir.absolutePath, "..", "platform").toFile()
