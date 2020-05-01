package br.com.natheuscalaca.timemaluco.utill.model;

public class ErrorUtil {

    private String msgError;

    public ErrorUtil() {
    }

    public ErrorUtil(String msgError) {
        this.msgError = msgError;
    }

    public String getMsgError() {
        return msgError;
    }

    public void setMsgError(String msgError) {
        this.msgError = msgError;
    }
}
