package com.example.config;

import com.ctrip.framework.apollo.core.ConfigConsts;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@EnableApolloConfig({ConfigConsts.NAMESPACE_APPLICATION, "TEST1.airlines"})
public class ApolloConfig {
    
    @Autowired
    private RefreshScope refreshScope;

    @ApolloConfigChangeListener
    public void onApplicationChange(ConfigChangeEvent changeEvent) {
        log.info(changeEvent.getNamespace());
        changeEvent.changedKeys().forEach(log::info);
    }

    @ApolloConfigChangeListener({"TEST1.airlines"})
    public void onAirlineChange(ConfigChangeEvent changeEvent) {
        log.info(changeEvent.getNamespace());
        changeEvent.changedKeys().forEach(log::info);
        refreshScope.refresh("airlineConfig");
    }
}
