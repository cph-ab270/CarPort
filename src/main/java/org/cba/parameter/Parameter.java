package org.cba.parameter;

import org.cba.parameter.exception.InvalidParameterTypeException;

/**
 * Created by adam on 24/05/2017.
 */
public interface Parameter<K> extends ParsedParameter<K>{
    void parseSendValue(String sendValue) throws InvalidParameterTypeException;
    boolean isRequired();
}
