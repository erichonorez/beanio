/*
 * Copyright 2011-2012 Kevin Seim
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
package org.beanio.internal.parser;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 
 * @author Kevin Seim
 * @since 2.0
 */
public class ArrayParser extends CollectionParser {

    private Class<?> arrayType;
    
    /**
     * Constructs a new <tt>ArrayParser</tt>.
     */
    public ArrayParser() { }
    
    @Override
    public int type() {
        return Property.AGGREGATION_ARRAY;
    }

    @Override
    public boolean isProperty() {
        return true;
    }
    
    @Override
    public Object getValue() {
        if (isInvalid()) {
            return super.getValue();
        }
        
        Collection<Object> collection = super.getCollection();
        if (collection == null) {
            return null;
        }
        
        int index = 0;
        Object array = Array.newInstance(arrayType, collection.size());
        for (Object obj : collection) {
            Array.set(array, index++, obj);
        }
        return array;
    }

    @Override
    public void setValue(Object value) {
        Collection<Object> collection = null;
        if (value != null) {
            int length = Array.getLength(value);
            if (length > 0) {
                collection = new ArrayList<Object>(length);
                for (int i=0; i<length; i++) {
                    collection.add(Array.get(value, i));
                }
            }
        }
        super.setValue(collection);
    }
    
    @Override
    protected Collection<Object> createCollection() {
        return new ArrayList<Object>();
    }

    public Class<?> getArrayType() {
        return arrayType;
    }

    public void setArrayType(Class<?> arrayType) {
        this.arrayType = arrayType;
    }
}
