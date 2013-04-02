package com.dubu.servlet;

import org.apache.catalina.startup.Tomcat;

import java.io.File;

/**
 * User: Administrator
 * Date: 13. 4. 2
 * Time: 오후 4:29
 */
public class TomcatServerMain {


    public static void main(String[] args) throws Exception {

        String webappDirLocation = "src/main/webapp/";
        Tomcat tomcat = new Tomcat();

        //The port that we should run on can be set into an environment variable
        //Look for that variable and default to 8080 if it isn't there.
        String webPort = System.getenv("PORT");
        if(webPort == null || webPort.isEmpty()) {
            webPort = "8090";
        }

        tomcat.setPort(Integer.valueOf(webPort));

        tomcat.addWebapp("/test", new File(webappDirLocation).getAbsolutePath());
        System.out.println("configuring app with basedir: " + new File("./" + webappDirLocation).getAbsolutePath());

        tomcat.start();
        tomcat.getServer().await();
    }


}
