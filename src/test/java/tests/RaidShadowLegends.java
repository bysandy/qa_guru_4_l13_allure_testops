package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static helpers.DriverHelper.getConsoleLogs;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

@Tag("web")
@Feature("Raid: Shadow Legends tests")
public class RaidShadowLegends extends TestBase {

    @Test
    @DisplayName("Opened Raid: Shadow Legends from Home")
    void shouldBeOpenedFromHomepageTest(){
        open("");
        $(by("data-qa-payload", "{\"title\":\"Raid: Shadow Legends\"}"))
                .click();

        $(byText("Эпическая коллекционная RPG")).shouldBe(visible);
    }

    @Test
    @DisplayName("Opened Raid: Shadow Legends with direct link")
    void shouldBeOpenedFromDirectLinkTest(){
        open("game/raid-shadow-legends/");

        $(byText("Эпическая коллекционная RPG")).shouldBe(visible);;
    }

    @Test
    @DisplayName("Console log doesn't have errors")
    void consoleLogShouldNotHaveErrors(){
        open("game/raid-shadow-legends/");
        String consoleLogs = getConsoleLogs();
        assertThat(consoleLogs, not(containsString("SEVERE")));
    }
}

