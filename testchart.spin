apply "EchartPlugin"

logSet{
   logPath = ["C:\\Users\\xtian\\Desktop\\main.log","C:\\Users\\xtian\\Desktop\\main1.log","C:\\Users\\xtian\\Desktop\\main2.log"]
}

chart{
   http("line") {
     title "Denali navkit memory (MB)"
     legend "available","rss","vmSize","Total"
     series {
       available {
        key "Available(MB):"
       }
       rss {
        key "Rss(MB):"
       }
       vmSize {
        key "VmSize(MB):"
       }
       total {
        key "Total(MB):"
       }
     }
   }
}