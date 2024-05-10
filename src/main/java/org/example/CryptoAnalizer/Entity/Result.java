package org.example.CryptoAnalizer.Entity;

import org.example.CryptoAnalizer.Exception.ApplicationException;
import org.example.CryptoAnalizer.repository.ResultCode;

public class Result {
    private ResultCode resultCode;
    private String message;
    private ApplicationException applicationException;

    public Result(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public Result(ResultCode resultCode, ApplicationException applicationException) {
        this.resultCode = resultCode;
        this.applicationException = applicationException;
    }
    public Result(ResultCode resultCode, String msg) {
        this.resultCode = resultCode;
        this.message = msg;
    }

    public String getMessage() {
        return message;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public ApplicationException getApplicationException() {
        return applicationException;
    }
}
