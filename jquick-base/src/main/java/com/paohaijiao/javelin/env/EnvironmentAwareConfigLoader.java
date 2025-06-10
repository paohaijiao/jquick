package com.paohaijiao.javelin.env;

import com.paohaijiao.javelin.reader.impl.JResourceYamlReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EnvironmentAwareConfigLoader {
    private final Map<String, Object> configMap = new HashMap<>();
    private String activeProfile = "dev"; //default active variable
    public EnvironmentAwareConfigLoader() {
        loadConfigurations();
    }
    public void setActiveProfile(String profile) {
        this.activeProfile = profile;
        loadConfigurations();
    }
    private void loadConfigurations() {
        loadYamlConfig("application.yml");
        String profileConfig = "application-" + activeProfile + ".yml";
        loadYamlConfig(profileConfig);
    }
    private void loadYamlConfig(String filename) {
        JResourceYamlReader<HashMap> yamlParser = new JResourceYamlReader<HashMap>();
        try {
            HashMap<String, Object> loaded = yamlParser.parse(filename, HashMap.class);
            if (loaded != null) {
                mergeMaps(configMap, loaded);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    private void mergeMaps(Map<String, Object> base, Map<String, Object> toMerge) {
        for (Map.Entry<String, Object> entry : toMerge.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (base.containsKey(key) && base.get(key) instanceof Map && value instanceof Map) {
                mergeMaps((Map<String, Object>) base.get(key), (Map<String, Object>) value);
            } else {//override
                base.put(key, value);
            }
        }
    }
    public Object getProperty(String key) {
        String[] keys = key.split("\\.");
        Map<String, Object> current = configMap;
        for (int i = 0; i < keys.length - 1; i++) {
            Object obj = current.get(keys[i]);
            if (obj instanceof Map) {
                current = (Map<String, Object>) obj;
            } else {
                return null;
            }
        }
        return current.get(keys[keys.length - 1]);
    }
    public Object getProperty(String key, Object defaultValue) {
        Object value = getProperty(key);
        return value != null ? value : defaultValue;
    }

}
