package com.appscharles.libs.reger.validators;

import com.appscharles.libs.processer.callers.CommanderCaller;
import com.appscharles.libs.processer.callers.CommanderResult;
import com.appscharles.libs.processer.callers.ICommanderCaller;
import com.appscharles.libs.processer.exceptions.ProcesserException;
import com.appscharles.libs.reger.exceptions.RegerException;

import java.text.MessageFormat;

/**
 * The type Autostart user validator.
 */
public class AutostartUserValidator {

    /**
     * Exist boolean.
     *
     * @param key the key
     * @return the boolean
     * @throws RegerException the reger exception
     */
    public static Boolean exist(String key) throws RegerException {
        try {
            final String REG_ADD_CMD = "cmd /c REG QUERY \"HKEY_CURRENT_USER\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Run\" /v \"{0}\"";
            String cmdLine = MessageFormat.format(REG_ADD_CMD, new Object[]{"\""+ key + "\""});
            ICommanderCaller caller = new CommanderCaller();
            CommanderResult result = caller.call(cmdLine);
            if (result.isError() && result.getOutput().contains("unable to find")){
                return false;
            } else if (result.isError()){
                throw new RegerException("Error validate exist ket in registry.");
            }
        } catch (ProcesserException e) {
            throw new RegerException(e);
        }
        return true;
    }
}
