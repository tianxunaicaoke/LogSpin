apply "BasePlugin"
println "hello LogSpin"

logSet{
   LogPath = ["C:\\Users\\xtian\\Downloads\\Logs\\Logs\\logcat\\NO2-2020-06-24-19-38-40.txt"]
}

info {
   Region{
     key = "loadAppConfig for region"
     description "current region :"
   }
   AppVersion {
        key = "[app version]"
        description "current version :"
   }
}


