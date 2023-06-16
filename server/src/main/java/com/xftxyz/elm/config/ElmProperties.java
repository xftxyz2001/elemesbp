package com.xftxyz.elm.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ConfigurationProperties(prefix = "elm")
public class ElmProperties {
}
