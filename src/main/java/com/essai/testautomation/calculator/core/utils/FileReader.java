package com.essai.testautomation.calculator.core.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Objects;

@Slf4j
public class FileReader {
    public String readFile(String fileName) {
        ClassLoader load = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(load.getResource(fileName)).getFile());
        return getString(file);
    }

    private String getString(File file) {
        try {
            return new String(Files.readAllBytes(file.toPath()));
        } catch (IOException e) {
            log.error("Error during reading of file: " + file.getAbsolutePath(), e);
            throw new IllegalArgumentException("Error during reading of file: " + file.getAbsolutePath(), e);
        }
    }
}
