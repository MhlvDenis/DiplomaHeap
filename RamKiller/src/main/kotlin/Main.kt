package ru.hse

import com.sun.management.HotSpotDiagnosticMXBean
import java.lang.System.getenv
import java.lang.management.ManagementFactory
import java.time.LocalDateTime

fun setup() {
    val heapDumpDir = getenv("HEAP_DUMP_DIR") ?: "/tmp/dump"
    val heapDumpFile = "dump-${LocalDateTime.now()}.hprof"
    val diagnosticMXBean = ManagementFactory.getPlatformMXBean(HotSpotDiagnosticMXBean::class.java)

    diagnosticMXBean.setVMOption("HeapDumpPath", "$heapDumpDir/$heapDumpFile")
}

fun main() {
    setup()

    val symbols = ('a'..'z') + ('A'..'Z') + ('0'..'9')
    val trash = mutableListOf<String>()
    while (true) {
        trash += (0..1024 * 1024).map { symbols.random() }.joinToString("")
    }
}
