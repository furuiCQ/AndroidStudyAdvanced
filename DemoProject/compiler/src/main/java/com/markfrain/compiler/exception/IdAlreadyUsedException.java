package com.markfrain.compiler.exception;


import com.markfrain.compiler.module.FactoryAnnotatedClass;

public class IdAlreadyUsedException extends RuntimeException {
    public IdAlreadyUsedException(FactoryAnnotatedClass factoryAnnotatedClass) {

    }
}
