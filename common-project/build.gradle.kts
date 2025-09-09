plugins {
    kotlin("jvm")
}

group = "org.commom"

dependencies {
    api(platform(project(":platform")))
}
