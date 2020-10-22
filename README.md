# LogSpin  
<img src="Spin.png" width="150px" alt="Spin Logo" />


 LogSpin is for user to custom the way to get information for log. You can customize the spin file to adapt to different scenarios, and you can extend its functionality by customizing plugins. LogSpin offers a flexible model that can support the different usage requirements for anyone.

## Get Start
### Quick Use
Create the Spin file. The Spin file like:
~~~
apply "AndroidPlugin" //Apply Plugin

logSet{
   logPath = ["xx","xx"] //log path
}

// Android plugin support
android{
   process "com.xx.xx.xxx", "com.xx.xx.xxx"
}

info {
   name1 {
     key = "xx"
     description "this is key"
   }
   name2 {
     key = "xx"
     description "this is another key"
   }
}

rule {
  when "condition1","condition2","condition3" then "print result"
}

def name2 = {
   when "condition1","condition2"
}

def name3 = {
   when "condition1","condition2"
}

when name2, name3 then "print result"

flow {
  name4 {
   key "xx"
  }

  name5 {
   key "xx","xx"
  }
}

~~~
Then click Run.bat
Click the run.bat, Select the Spin file.  
![image](Run.png)
### Base Element
   *Info* :
   > To get the message not changed in the hole log file.
  
   *Rule* :
   > To get the message is not change during one log scope(like the android plugin support process scope), and this element work with "When" and "Then".
    
   *When* :
   > Set the condition keyword for check 
   *Then* :
   > Set the condition result
   
   *Flow* :
   > To get the message will change during the one log scope, and this kind key word can make a flow of work.

## framework
![image](design.png)