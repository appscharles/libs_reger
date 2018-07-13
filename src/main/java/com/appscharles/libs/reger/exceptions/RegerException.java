package com.appscharles.libs.reger.exceptions;

/**
 * The type Updater exception.
 */
public class RegerException extends Exception {
    /**
     * The Serial version uid.
     */
    static final long serialVersionUID = 3121375828146020432L;

    /**
     * Instantiates a new Updater exception.
     */
    public RegerException() {
        super();
    }

    /**
     * Instantiates a new Updater exception.
     *
     * @param message the message
     */
    public RegerException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Updater exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public RegerException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Updater exception.
     *
     * @param cause the cause
     */
    public RegerException(Throwable cause) {
        super(cause);
    }
}

