plugins {
    base
}

tasks.register("detekt")

val baseTasks = listOf("clean", "check", "build", "assemble", "detekt")
baseTasks.forEach { taskName ->
    bindTask(tasks.getByName(taskName))
}

fun bindTask(task: Task) {
    gradle.includedBuilds.forEach { build ->
        task.dependsOn(build.task(":${task.name}"))
    }
}
