apply "EchartPlugin"

logSet{
   logPath = ["C:\\Users\\xtian\\Desktop\\main.log","C:\\Users\\xtian\\Desktop\\main1.log","C:\\Users\\xtian\\Desktop\\main2.log"]
}

chart{
   http("line") {
     title "denali http line chart"
     legend "traffic","search"
     series {
       traffic{
        data "memory use: current ="
       }
       search{
        data 10,12,13,14,12,42,21,11
       }
     }
   }
}