package com.mason.practice.boot330.component;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PropertiesLogger implements CommandLineRunner {

    private final ConfigurableEnvironment env;

    public PropertiesLogger(ConfigurableEnvironment env) {
        this.env = env;
    }

    @Override
    public void run(String... args) {
        MutablePropertySources sources = env.getPropertySources();
        System.out.println("====== Environment and configuration properties ======");
        System.out.println("====== Active Profile = " + env.getActiveProfiles()[0] + " ======");

        sources.forEach(ps -> {
            if (ps != null && ps.getSource() instanceof Map<?, ?> && ((Map<?, ?>) ps.getSource()).size() > 0) {
                printPropertySource(ps);
            }
        });
    }

    private void printPropertySource(PropertySource<?> ps) {
        System.out.println("Property Source: " + ps.getName());
        Object source = ps.getSource();
        if (source instanceof Map<?, ?> map) {
            map.forEach((key, value) -> System.out.printf("    %-40s= %s%n",key ,value));
        }
    }
}