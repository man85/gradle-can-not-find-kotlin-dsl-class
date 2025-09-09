import kotlin.io.path.Path

val rootProjectName: String by settings
rootProject.name = rootProjectName

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenLocal()
    }
}

pluginManagement {
    includeBuild(".." + File.separator + "common-plugins")
    repositories {
            mavenLocal()
    }
    plugins {
        kotlin("jvm") version "1.9.24"
    }
}

include(":platform")
project(":platform").projectDir = Path(settingsDir.absolutePath, "..", "platform").toFile()
