package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.external.GoogleAuthPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static config.ConfigHelper.isVideoOn;
import static helpers.AttachmentsHelper.*;
import static helpers.DriverHelper.*;

public class TestBase {
    GoogleAuthPage googleAuthPage = new GoogleAuthPage();

    @BeforeAll
    public static void beforeAll(){
        configureDriver();
    }

    @AfterEach
    public void addAttachments(){
        String sessionId = getSessionId();

        attachScreenshot("Last screenshot");
        attachPageSource();
//        attachNetwork(); // todo
        attachAsText("Browser console logs", getConsoleLogs());
        System.out.println("video.storage");
        if (isVideoOn()) {
            attachVideo(sessionId);
        }

        closeWebDriver();
    }
}
