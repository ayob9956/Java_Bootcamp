package com.example.library.ApiRespons;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ApiException extends RuntimeException{
    public ApiException(String message){
        super(message);
    }
}
