package ingjulianvega.ximic.msscasucompanion.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "companion")
public class CompanionParameters {

    private String api;
}
