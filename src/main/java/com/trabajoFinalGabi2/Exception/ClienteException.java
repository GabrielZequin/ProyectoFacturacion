package com.trabajoFinalGabi2.Exception;

import lombok.Data;

@Data
public class ClienteException extends RuntimeException{

    public ClienteException (String message){
        super(message);
    }
}
