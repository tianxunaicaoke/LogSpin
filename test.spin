apply "BasePlugin"
println "hello LogSpin"
info {
   println "hello info"
   Region{
     println "hello Region"
   }
   Version{
      println "hello version"
   }
   tt {
     println "hello inner info"
     Region{
          println "inner Region"
     }
   }
}


