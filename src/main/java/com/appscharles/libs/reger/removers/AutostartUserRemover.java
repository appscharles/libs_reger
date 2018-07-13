package com.appscharles.libs.reger.removers;

import com.appscharles.libs.processer.callers.CommanderCaller;
import com.appscharles.libs.processer.callers.CommanderResult;
import com.appscharles.libs.processer.callers.ICommanderCaller;
import com.appscharles.libs.processer.exceptions.ProcesserException;
import com.appscharles.libs.reger.exceptions.RegerException;
import com.appscharles.libs.reger.validators.AutostartUserValidator;

import java.text.MessageFormat;

/**
 * The type Autostart user remover.
 */
public class AutostartUserRemover {

    /**
     * Remove.
     *
     * @param key the key
     * @throws RegerException the reger exception
     */
    public static void remove(String key) throws RegerException {
        try {
            if (AutostartUserValidator.exist(key) == false) {
                return;
            }
            final String REG_ADD_CMD = "cmd /c reg delete \"HKEY_CURRENT_USER\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Run\" /v \"{0}\" /f";
            String cmdLine = MessageFormat.format(REG_ADD_CMD, new Object[]{"\""+ key + "\""});
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
