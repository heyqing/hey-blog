package top.heyqing.heyblog.config;

import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

import static top.heyqing.heyblog.model.enums.ZoneEnum.SHANGHAI;

/**
 * ClassName:GlobalZoneConfig
 * Package:top.heyqing.heyblog.config
 * Description:
 *
 * @Date:2024/12/1
 * @Author:Heyqing
 */
@Configuration
public class GlobalZoneConfig {

    @PostConstruct
    public void setGlobalZone() {
        TimeZone.setDefault(TimeZone.getTimeZone(SHANGHAI.getZone()));
    }

}

