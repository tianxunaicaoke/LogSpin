apply "AndroidPlugin"

logSet{
   logPath = ["C:\\Users\\xtian\\Downloads\\gmlogger\\main.log",
   "C:\\Users\\xtian\\Downloads\\gmlogger\\97-main.log_2020_9_29_8_58_43\\97-main.log"]
}

android{
   process "com.telenav.app.denali.na","com.telenav.app.denali.na:cluster"
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
   clusterView {
    key  "viewId="
    description "cluster view"
   }
}

rule {
  when "pcLabel:  Work" then "has card"
  when "is a car","is bench","nav on" then "is telenav"
}

def hasCard = {
   when "is na region","has destination"
}

def mount = {
   when "SDCard has in","is legal"
}

when hasCard, mount then "123"



