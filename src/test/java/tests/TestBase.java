package tests;

import com.codeborne.selenide.Configuration;
import io.github.qaguru.owner.WebDriverConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.AttachmentsHelper.*;

public class TestBase {
    static final WebDriverConfig config= ConfigFactory
            .create(WebDriverConfig.class, System.getProperties());

    @BeforeAll
    static void setup() {
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        Configuration.browser = config.getWebDriverBrowser();
        Configuration.browserVersion = config.getWebDriverBrowserVersion();
//        Configuration.browser = System.getProperty("browser", "chrome"); for jenkins
        Configuration.startMaximized = true;

        if(config.getRemoteWebDriver() != null) {
            // config for Java + Selenide
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
        Configuration.remote = config.getRemoteWebDriver();
 //       Configuration.remote = System.getProperty("remote_driver"); need to add parameters in  jenkins
 //       Configuration.remote = "https://user1:1234@selenoid.autotests.cloud:4444/wd/hub/"; hardcode
        }
    }
    @AfterEach
    public void afterEach() {
        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browser console logs", getConsoleLogs());
        if(config.getVideoStorage() != null) {
            attachVideo();
        }
//        need to add parameters in  jenkins
//        if(System.getProperty("video_storage") != null) {
//            attachVideo();
//        }
        closeWebDriver();
    }
}