apply "BasePlugin"
println "hello LogSpin"

logSet{
   logPath = ["C:\\Users\\xtian\\Downloads\\gmlogger\\main.log",
   "C:\\Users\\xtian\\Downloads\\gmlogger\\97-main.log_2020_9_29_8_58_43\\97-main.log"]
}

info {
   region{
     key = "loadAppConfig for region"
     description "current region"
   }
   appVersion {
        key = "[app version]"
        description "current version"
   }
   time {
    key  "19:37:25.538 28368 28458"
    description "test"
   }
}

rule {
  when "this is predictive card" then "PC"
  when "is a car","is bench","nav on" then "is telenav"
}

def hasCard = {
   when "is na region","has destination"
}

def mount = {
   when "SDCard has in","is legal"
}

when hasCard, mount then "123"



