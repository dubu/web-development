package com.dubu;

/**
 * User: Administrator
 * Date: 13. 4. 3
 * Time: 오전 10:48
 */

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
    public void searchPesonByIdOneTest() {
        browser.get(tomcat.getApplicationUrl("do/search?id=0"));
        assertEquals("30", browser.findElement(By.id("age")).getText());

        //browser.get(tomcat.getApplicationUrl("do/search?id=1"));
        //assertEquals("27", browser.findElement(By.id("age")).getText());

        //browser.get(tomcat.getApplicationUrl("do/search?id=2"));
        //assertEquals("21", browser.findElement(By.id("age")).getText());
    }

    @Test
    public void searchPesonByIdTwoTest() {
        browser.get(tomcat.getApplicationUrl("do/search?id=1"));
        assertEquals("27", browser.findElement(By.id("age")).getText());
    }

    @Test
    public void searchPesonByIdThreeTest() {
        browser.get(tomcat.getApplicationUrl("do/search?id=2"));
        assertEquals("21", browser.findElement(By.id("age")).getText());
    }

    @AfterClass
    public static void tearDown() {
        //System.out.println(browser.getPageSource());
        browser.close();
        tomcat.stop();
    }
}
