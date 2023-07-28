package com.essai.testautomation.calculator.core.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.Map;

@Slf4j
public class CapabilitiesHelper {
    public static Map<String, String> readAndMakeCapabilities(String fileName) {
        String caps = new FileReader().readFile(fileName);
        Map<String, String> map = convertCapsToMap(caps);
        updateAbsolutePath(map);
        return map;
    }

    private static Map<String, String> convertCapsToMap(String caps) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(caps, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            log.error("Error during reading conversion of Capabilities", e);
            throw new IllegalArgumentException("Error during reading conversion of Capabilities", e);
        }
    }

    private static void updateAbsolutePath(Map<String, String> map) {
        String path = map.get("app");
        File appPath = new File(path);
        map.put("app", appPath.getAbsolutePath());
    }
}
