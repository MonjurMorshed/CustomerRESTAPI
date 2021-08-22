package practice;

import java.io.File;
import java.io.IOException;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.logging.Level;


import java.util.Iterator;

public class RefactorThisClassLegacy {

    public static String getJarVersion(File file) {
        JarFile jar;
        Manifest manifest;
        String versionNumber = "";
        try {
            if (file.exists()) {
                jar = new JarFile(file);
                manifest = jar.getManifest();
                Attributes attributes = manifest.getMainAttributes();
                if (attributes != null) {
                    Iterator<Object> it = attributes.keySet().iterator();
                    while (it.hasNext()) {
                        Attributes.Name key = (Attributes.Name) it.next();
                        String keyword = key.toString();
                        if (keyword.equals("Implementation-Version")) {
                            versionNumber = (String) attributes.get(key);
                            break;
                        }
                    }
                }
                jar.close();
            } else {
                logError("Jar not found: " + file.getAbsolutePath(), null);
            }
        } catch (IOException e) {
            logError("Error getting jar version", e);
        }
        return versionNumber;
    }

    private static void logError(String message, Throwable throwable) {
        java.util.logging.Logger.getLogger("Version").log(Level.SEVERE, message, throwable);
    }

    public static void main(String[] args) {
        System.out.println(getJarVersion(new File("some.jar")));
    }
}