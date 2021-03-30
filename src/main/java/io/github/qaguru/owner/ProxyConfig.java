package io.github.qaguru.owner;

import org.aeonbits.owner.Config;

public interface ProxyConfig extends Config {

    @Key("host")
    @DefaultValue("proxy.company.com")
    String host();

    @Key("port")
    @DefaultValue("4444")
    int port();

    @Key("enabled")
    @DefaultValue("true")
    boolean enabled();
}
