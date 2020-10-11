apply "BasePlugin"
println "hello LogSpin"

logSet{
   logPath = ["C:\\Users\\xtian\\Downloads\\Logs\\Logs\\logcat\\NO2-2020-06-24-19-38-40.txt",
   "C:\\Users\\xtian\\Downloads\\Logs\\Logs\\logcat\\NO1-2020-06-24-19-38-03.txt"]
}

info {
   region{
     key = "loadAppConfig for region"
     description "current region :"
   }
   appVersion {
        key = "[app version]"
        description "current version :"
   }
   time {
    key  "19:37:25.538 28368 28458"
    description "test"
   }
}

rule {
  when "this is predictive card" then "PC"
}

def hasCard = {
   when "","",""
}

def mount = {
   when "",""
}

when hasCard, mount then "123"



