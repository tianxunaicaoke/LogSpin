package org.logSpin.process

@SuppressWarnings("unused")
class FileWriterHelper {
    def text_carve = "======>"
    def text_logSpin = "----------LoginSpin----------"
    def text_info = " info"
    def text_analyze = " analyze"
    FileWriterHelper(){
        clearFile()
    }
    static def clearFile(){
        def fileWriter = new FileWriter("report.txt")
        fileWriter.write("")
        fileWriter.flush()
        fileWriter.close()
    }

    static def writeln( fileWriter, value) {
        fileWriter.write(value)
        fileWriter.append("\n")
        fileWriter.flush()
    }

    static def write( fileWriter, value) {
        fileWriter.write(value)
        fileWriter.flush()
    }

    def writeInfo(Object infos) {
        def fileWriter = new FileWriter("report.txt", true)
        writeln(fileWriter, text_logSpin)
        write(fileWriter, text_carve)
        writeln(fileWriter, text_info)
        infos.each {
            it -> writeln(fileWriter,it.toString())
        }
        fileWriter.close()
    }

    def writeRule(Object rules) {
        def fileWriter = new FileWriter("report.txt", true)
        write(fileWriter, text_carve)
        writeln(fileWriter,text_analyze )
        rules.each {
            it -> writeln(fileWriter, it)
        }
    }
}
