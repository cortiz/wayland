package com.jmpeax.wayland;


import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyCodeSource;
import groovy.lang.GroovyShell;
import org.codehaus.groovy.control.CompilerConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class Wayland {

    private static Logger log = LoggerFactory.getLogger(Wayland.class);
    static Properties p = new Properties();

    public static void main(String[] args) throws IOException, ScriptException, URISyntaxException {
        p.load(Wayland.class.getResourceAsStream("/version.properties"));
        log.info("Wayland {} {} {} ",p.getProperty("com.jmpeax.wayland.version"),p.getProperty("com.jmpeax.wayland.build"),
                          new SimpleDateFormat("YYYY-MM-dd").format(
                          new Date(Long.parseLong(p.getProperty("com.jmpeax.wayland.buildOn")))));

        URL loader[] = new URL[]{Wayland.class.getResource("/groovy")};
        CompilerConfiguration compilerConfiguration = new CompilerConfiguration();
        compilerConfiguration.setClasspath(Wayland.class.getResource("/groovy").getPath());
        compilerConfiguration.setScriptBaseClass("groovy.main");
        GroovyShell groovyShell = new GroovyShell(compilerConfiguration);
    //    groovyShell.getContext().setVariable("duty", groovyShell.evaluate(new InputStreamReader(Wayland.class.getResourceAsStream("/groovy/main.groovy"),"UTF-8")));
        groovyShell.evaluate(new InputStreamReader(Wayland.class.getResourceAsStream("/groovy/hello.groovy"),"UTF-8"));

    }
}
