package com.appscharles.libs.reger.creators;

import com.appscharles.libs.ioer.services.FileWriter;
import com.appscharles.libs.reger.adders.AutostartUserAdder;
import com.appscharles.libs.reger.exceptions.RegerException;

import java.io.File;
import java.io.IOException;

/**
 * The type Autostart creator.
 */
public class AutostartCreator {

    /**
     * Create.
     *
     * @param regKey  the reg key
     * @param batFile the bat file
     * @param command the command
     * @throws RegerException the reger exception
     */
    public static void create(String regKey, File batFile, String command) throws RegerException {
            try {
                FileWriter.write(batFile, command);
                AutostartUserAdder.add(regKey, batFile);
            } catch (IOException e) {
                throw new RegerException(e);
            }
        }
}
