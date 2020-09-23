
    def search() {
        File file = new File("C:\\User\\xtian\\Downloads\\Logs\\Logs\\logcat\\NO2-2020-06-24-19-38-40.txt")
        file.filterLine {
            line ->
                ////s.each {
                    line.contains("loadAppConfig for region")
                //}
        }.writeTo(new PrintWriter(System.out))
    }

