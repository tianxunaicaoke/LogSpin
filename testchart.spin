apply "EchartPlugin"

logSet{
   logPath = ["C:\\Users\\xtian\\Desktop\\main.log","C:\\Users\\xtian\\Desktop\\main1.log","C:\\Users\\xtian\\Desktop\\main2.log"]
}

chart{
   http("Pie") {
     title "Denali navkit memory (MB)"
     series {
       ss {
         data 121,323,332
       }
     }
   }
}