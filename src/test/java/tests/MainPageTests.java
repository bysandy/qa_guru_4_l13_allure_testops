package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Tag("web")
@Feature("Homepage tests")
public class MainPageTests extends TestBase {

    @Test
    @DisplayName("Page should have button \"Скачать Plarium Play\"")
    void titleHomePageTest(){
        open("");

        $(by("data-qa-entity", "menu.download.plarium.play"))
                .shouldHave(text("Скачать Plarium Play"));
    }

    @Test
    @DisplayName("Header menu should be available")
    void headerMenuLoadedTest(){
        open("");

        $(by("data-qa-payload", "{\"title_name\":\"Игры\"}"))
                .shouldBe(visible);
        $(by("data-qa-payload", "{\"title_name\":\"Сообщество\"}"))
                .shouldBe(visible);
        $(by("data-qa-payload", "{\"title_name\":\"Ресурсы\"}"))
                .shouldBe(visible);
    }

    @Test
    @DisplayName("Page should change language")
    void changeLanguageTest() {
        open("");

        $(by("data-qa-entity", "header.select.language"))
                .click();
        $(by("data-qa-payload", "{\"title\":\"Italiano\"}"))
                .click();

        $(by("data-qa-entity", "menu.download.plarium.play"))
                .shouldHave(text("Ottieni Plarium Play"));
    }


}
