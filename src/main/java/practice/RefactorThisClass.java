package practice;

import org.apache.tomcat.Jar;
import org.w3c.dom.Attr;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.logging.Level;

/**
 *
 * This class is taken almost as is from the source code of one of our products.
 * It has a utility method getJarVersion() that retrieves the implementation version of a JAR.
 *
 * Your tasks:
 *  (a) A junior member of the team has committed this code. You are the reviewer. Improve it as much as you can.
 *  (b) The function works, but if you think there's something to improve e.g. in error handling, please implement the enhancements.
 *  (c) Add JavaDoc comment on top of the getJarVersion() function
 *  (d) Add unit test(s) by using JUnit. If you need to mock something, use JMockit library.
 *
 */
public class RefactorThisClass {

    /**
     * This method is used for to read the implemented version number for a given Jar file.
     *
     * @param file - the Jar file to be opened for reading
     * @return String - returns the jar's implemented version or empty if does not exist
     */
    public static String getJarVersion(File file) {
        AtomicReference<String> jarVersionNumber = new AtomicReference<>("");
        if (file.exists()) {
            try (JarFile jarfile  = new JarFile(file)) {  // used for auto-closable for jar file
               try {
                    Optional<Manifest> manifestOptional = Optional.ofNullable(jarfile.getManifest()); // use optional since it has possibility to get null object
                    manifestOptional.ifPresent( manifest -> {
                        Attributes attributes = manifest.getMainAttributes(); // Manifest has default 11 attributes. so it will return a set of attributes
                        Attributes.Name searchKey = new Attributes.Name("Implementation-Version");
                        Optional<Object> implementedVersion = Optional.ofNullable(attributes.get(searchKey));
                        if(implementedVersion.isPresent()) {
                            jarVersionNumber.set(implementedVersion.get().toString());
                        }
                    });
                } catch (IOException e) {
                    logError(new Exception("Error occurred while reading the jar's manifest info", e));
                }
            } catch (IOException e) {
                logError(new Exception("Error occurred while reading the jar file", e));
            }
        } else {
            logError(new Exception("Jar file is missing at the location : " + file.getAbsolutePath()));
        }
        return jarVersionNumber.get();
    }

    private static void logError(Exception exp) {
        java.util.logging.Logger.getLogger("Version").log(Level.SEVERE, exp.getMessage(), exp);
    }

    public static void main(String[] args) {
        System.out.println(getJarVersion(new File("C:\\Users\\MonjurMorshed\\Downloads\\httpclient-4.5.81.jar")));
    }
}