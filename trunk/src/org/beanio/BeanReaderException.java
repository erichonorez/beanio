/*
 * Copyright 2010-2011 Kevin Seim
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.beanio;

/**
 * A subclass of <tt>BeanReaderException</tt> is thrown for any exception
 * that occurs while using a <tt>BeanReader</tt> to read from an input stream.
 * 
 * @author Kevin Seim
 * @since 1.0
 * @see BeanReader
 */
public abstract class BeanReaderException extends BeanIOException {

    private static final long serialVersionUID = 1L;

    private BeanReaderContext context;

    /**
     * Constructs a new <tt>BeanReaderException</tt>.
     * @param context the current context of the bean reader
     * @param message the error message
     */
    public BeanReaderException(BeanReaderContext context, String message) {
        this(context, message, null);
    }

    /**
     * Constructs a new <tt>BeanReaderException</tt>.
     * @param context the current context of the bean reader
     * @param message the error message
     * @param cause the root cause
     */
    public BeanReaderException(BeanReaderContext context, String message, Throwable cause) {
        super(message, cause);
        this.context = context;
    }

    /**
     * Returns the current state of the bean reader.
     * @return bean reader context
     */
    public BeanReaderContext getContext() {
        return context;
    }
}