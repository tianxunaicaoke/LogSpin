package org.logSpin.process

@SuppressWarnings("unused")
class FileWriterHelper {
    String text_carve = "======>"
    String text_logSpin = "----------LoginSpin----------"
    String text_info = " info"
    String text_procss = " process"
    String text_analyze = " analyze"

    FileWriterHelper() {
        clearFile()
    }

    static def clearFile() {
        def fileWriter = new FileWriter("report.txt")
        fileWriter.write("")
        fileWriter.flush()
        fileWriter.close()
    }

    static def writeln(fileWriter,  value) {
        fileWriter.write(value)
        fileWriter.append("\n")
        fileWriter.flush()
    }

    static def write(fileWriter, value) {
        fileWriter.write(value)
        fileWriter.flush()
    }

    def writeInfo(Object infos) {
        def fileWriter = new FileWriter("report.txt", true)
        writeln(fileWriter, text_logSpin)
        write(fileWriter, text_carve)
        writeln(fileWriter, text_info)
        infos.each {
            it -> writeln(fileWriter, it.toString())
        }
        fileWriter.close()
    }

    def writeRule(Object rules) {
        def fileWriter = new FileWriter("report.txt", true)
        write(fileWriter, text_carve)
        writeln(fileWriter, text_analyze)
        rules.each {
            it -> writeln(fileWriter, it)
        }
    }

    def writeProcess(Object rules) {
        def fileWriter = new FileWriter("report.txt", true)
        write(fileWriter, text_carve)
        writeln(fileWriter, text_procss)
        rules.each {
            it -> writeln(fileWriter, it)
        }
    }
}
