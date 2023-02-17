// Copyright (C) 2011 - Will Glozer.  All rights reserved.

package com.example.demo.hash.jni;

/**
 * Exception thrown when the current platform cannot be detected.
 *
 * @author Will Glozer
 */
public class UnsupportedPlatformException extends RuntimeException {
	private static final long serialVersionUID = 1L;

    /**
     *
     * @param s
     */
    public UnsupportedPlatformException(String s) {
        super(s);
    }
}