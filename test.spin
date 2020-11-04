apply "AndroidPlugin"
apply "NavigationPlugin"

logSet{
   logPath = ["C:\\Users\\xtian\\Desktop\\main.log"]
}

android{
   process "com.telenav.app.denali.na"
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
  when "pcLabel:  Work" then "has Work card"
  when "startRouteCalculate","notifyCardEstimationTimeCalculated" then "has calculate route"
}

def hasCard = {
   when "is na region","has destination"
}

def mount = {
   when "SDCard has in","is legal"
}

when hasCard, mount then "123"

flow {
  predictiveCard{
   key "fetchDestinations","fetching key destinations"
  }

  ShowEteOnCluster{
  key "invoke refreshETAByNavKit","notify smart card estimation time: topBox","Received notifyListContentChanged request"
  }
}