package com.dubu.servlet;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class IntegrationTestWithTomcat {
    private static EmbeddedTomcat tomcat = new EmbeddedTomcat();
    private static WebDriver browser;

    @BeforeClass
    public static void setUp() {
        tomcat.start();
        tomcat.deploy("");
        browser = new HtmlUnitDriver();
    }

    @Test
    public void test() {
        browser.get(tomcat.getApplicationUrl("/index.jsp"));
        assertEquals("App", browser.findElement(By.id("name")).getText());
    }

    @Test
    public void jspHelloTest() {
        browser.get(tomcat.getApplicationUrl("hello.jsp"));
        assertEquals("Hi", browser.findElement(By.id("name")).getText());
    }

    @Test
    public void servletHelloTest() {
        browser.get(tomcat.getApplicationUrl("do/hello"));
        assertEquals("dubu", browser.findElement(By.id("name")).getText());
    }

    @Test
    public void asdfdasfafds(){
        browser.get(tomcat.getApplicationUrl("do/fjalsjfdlasjdfljadlsfjlds"));

    }


    @AfterClass
    public static void tearDown() {
        //System.out.println(browser.getPageSource());
        browser.close();
        tomcat.stop();
    }
}
