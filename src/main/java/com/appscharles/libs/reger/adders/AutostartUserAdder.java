package com.appscharles.libs.reger.adders;

import com.appscharles.libs.processer.callers.CommanderCaller;
import com.appscharles.libs.processer.callers.CommanderResult;
import com.appscharles.libs.processer.callers.ICommanderCaller;
import com.appscharles.libs.processer.exceptions.ProcesserException;
import com.appscharles.libs.reger.exceptions.RegerException;
import com.appscharles.libs.reger.removers.AutostartUserRemover;

import java.io.File;
import java.text.MessageFormat;

/**
 * The type Autostart user adder.
 */
public class AutostartUserAdder {

    /**
     * Add.
     *
     * @param key            the key
     * @param executableFile the executable file
     * @throws RegerException the reger exception
     */
    public static void add(String key, File executableFile) throws RegerException {
        try {
            AutostartUserRemover.remove(key);
            final String REG_ADD_CMD = "cmd /c reg add \"HKEY_CURRENT_USER\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Run\" /v \"{0}\" /d \"{1}\" /t REG_SZ";
            String cmdLine = MessageFormat.format(REG_ADD_CMD, new Object[]{"\""+ key + "\"", "\""+ executableFile.getAbsolutePath() + "\""});
            ICommanderCaller caller = new CommanderCaller();
            CommanderResult result = caller.call(cmdLine);
            if (result.isError()) {
                throw new RegerException(result.getOutput());
            }
        } catch (ProcesserException e) {
            throw new RegerException(e);
        }
    }
}
