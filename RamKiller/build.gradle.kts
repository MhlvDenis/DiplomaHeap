plugins {
    kotlin("jvm") version "2.0.10"
    application
}

application {
    applicationName = project.name
    group = "ru.hse"
    mainClass.set("ru.hse.MainKt")
    applicationDefaultJvmArgs += listOf(
        "-Xmx256m", // Set Heap size
        "-XX:+ExitOnOutOfMemoryError",
        "-XX:+HeapDumpOnOutOfMemoryError",
        "-XX:HeapDumpPath=/tmp/dump/dump.hprof", // Overrides by main
    )
}

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(17)
}