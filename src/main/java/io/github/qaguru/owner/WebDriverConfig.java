package io.github.qaguru.owner;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:${environment}.properties")
public interface WebDriverConfig extends Config {

    @Key("webDriverBrowser")
//    @DefaultValue("chrome")
    String getWebDriverBrowser();

    @Key("webDriverBrowserVersion")
//   @DefaultValue("87.0")
    String getWebDriverBrowserVersion();

    @Key("remoteWebDriver")
    String getRemoteWebDriver();

    @Key("videoStorage")
    String getVideoStorage();
}
