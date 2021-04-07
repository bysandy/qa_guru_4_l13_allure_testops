package tests;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import config.ConfigHelper;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Tag("web")
@Feature("Login tests")
public class LoginTests extends TestBase {

    @Test
    @DisplayName("Successful Login with Email authorisation")
    void loginWithEmail(){
        step("Open home page", () -> open(""));

        step("Fill in email", () ->{
            $(by("data-qa-entity", "header.login"))
                    .click();
            $(by("data-qa-entity", "login.email.section"))
                    .setValue(ConfigHelper.getEmailUsername());
            $(by("data-qa-entity", "auth.next.step"))
                    .click();
        });

        step("Fill in password", () ->{
            $(by("data-qa-entity", "login.password.section"))
                    .setValue(ConfigHelper.getEmailPassword());
            $(by("data-qa-entity", "auth.send.button")).shouldBe(enabled)
                   .click();
        });

        step("Verified that user sees correct page", () ->{
            $(by("data-qa-entity", "choose.close"))
                    .click();

            $(by("data-qa-payload", "{\"title_name\":\"Моя библиотека\"}"))
                    .shouldBe(visible);
        });

    }
}
