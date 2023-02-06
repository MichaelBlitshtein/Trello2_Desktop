package tests;

import manage.ApplicationManager;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestBase {
    Logger logger = LoggerFactory.getLogger(TestBase.class);
    static ApplicationManager app = new ApplicationManager(System.getProperty("browser",Browser.CHROME.browserName()));

    @BeforeSuite(alwaysRun = true)
    public void  setUp(){
        app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void stop(){
        app.quit();
    }

    @BeforeMethod(alwaysRun = true)
    public void startLogger(Method method){
        logger.info("Test starts----" +method.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void finishLogger(){
        logger.info("***********************");
    }
}