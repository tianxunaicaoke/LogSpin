# LogSpin  
<img src="Spin.png" width="150px" alt="Spin Logo" />

[toc]

 LogSpin is for user to custom the way to get information for log. You can customize the spin file to adapt to different scenarios, and you can extend its functionality by customizing plugins. LogSpin offers a flexible model that can support the different usage requirements for anyone.

## Get Start
### Quick Use
First Create the Spin file. The example Spin file will be introduced later.
 1. For tool user:
   > First to download the Spin-tool.zip, Unzip and then click Run.bat, fill the log path to Spin, and select the Spin file.  
<img src="Run.png" width="250px" />
 2. For code user:
   > First to add dependency
   ~~~
   repositories {
         maven{
             url = "http://172.16.212.70:8081/nexus/content/repositories/snapshots/"
         }
         ...
     }
   dependencies {
    ...
    implementation 'org.xtian.logspin:launch:1.1-SNAPSHOT'
  }
   ~~~
  >Then to create a main function like:
  ~~~
  import org.logSpin.launch.LauncherHelper;
  
  public class Main {
      public static void main(String[] args) {
          LauncherHelper launcherHelper = new LauncherHelper();
          launcherHelper.run(args);
      }
  }
  ~~~
  >And then you can run main with spin file path as args.
### Base Element
   *Info* :
   > To get the message not changed in the hole log file.
  
   *Rule* :
   > To get the message is not change during one log scope(like the android org.logSpin.annotation.plugin support process scope), and this element work with "When" and "Then".
    
   *When* :
   > Set the condition keyword for check 
   *Then* :
   > Set the condition result
   
   *Flow* :
   > To get the message will change during the one log scope, and this kind key word can make a flow of work.
### Spin file
  1. First apply the plugin you need , the default BasePlugin already apply by default
~~~
apply "AndroidPlugin" //Apply Plugin

...
// Android org.logSpin.annotation.plugin support
android{
   process "com.xx.xx.xxx", "com.xx.xx.xxx"
}
~~~
  2. Set the log path to Spin system
~~~
logSet{
   logPath = ["xx","xx"] //log path
}
~~~
  3. Some examples of basic elements , which are supported in BasePlugin.  
~~~
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
~~~
~~~
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
~~~
~~~
flow {
  name4 {
   key "xx"
  }

  name5 {
   key "xx","xx"
  }
}
~~~
### how to apply the plugin
 1. First add dependency.
 ~~~
   repositories {
         maven{
             url = "http://172.16.212.70:8081/nexus/content/repositories/snapshots/"
         }
         ...
     }
   dependencies {
    ...
    //use NavigationPlugin for exampe
    implementation 'org.example:NavigationPlugin:1.0-SNAPSHOT'
  }
 ~~~
 then follow the run by code.

### how to write plugin
 1. First set up the code run environment as above. 


### how to export the plugin



## framework
<img src="design.png" />