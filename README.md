# selenium-grid-sample


## Master/Hub
$$$ java -jar selenium-server-standalone-3.141.59.jar -role hub \
Selenium Grid hub is up and running at http://-ip-:4444/grid/console \
Nodes should register to http://-ip-:4444/grid/register/ \
Clients should connect to http://-ip->:4444/wd/hub \

## Slave/Node
$$$ java -Dwebdriver.chrome.driver="C:\Users\Administrator\Downloads\chromedriver.exe" -jar selenium-server-standalone-3.141.59.jar -role node  -hub  http://-hubip-:4444/grid/register/ 



```
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>3.141.59</version>
</dependency>
```
   
