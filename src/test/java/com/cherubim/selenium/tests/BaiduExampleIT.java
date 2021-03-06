package com.cherubim.selenium.tests;

import com.cherubim.selenium.page_objects.BaiduHomePage;
import com.cherubim.selenium.DriverBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * 百度网页测试
 */
public class BaiduExampleIT extends DriverBase {

    private ExpectedCondition<Boolean> pageTitleStartsWith(final String searchString) {
        return driver -> driver.getTitle().toLowerCase().startsWith(searchString.toLowerCase());

    }

    @Test
    public void baiduSearchExample() throws Exception {
        // 创建webDriver
        WebDriver driver = getDriver();

        // 添加网址
        driver.get("http://www.baidu.com");

        // 或者如下方式
        // driver.navigate().to("http://www.baidu.com");

        BaiduHomePage baiduHomePage = new BaiduHomePage();

        System.out.println("Page title is: " + driver.getTitle());

        baiduHomePage.enterSearchTerm("李彦宏").submitSearch();

        WebDriverWait wait = new WebDriverWait(driver, 10, 100);
        wait.until(pageTitleStartsWith("李彦宏"));

        System.out.println("Page title is: " + driver.getTitle());
    }

}