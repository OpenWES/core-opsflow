package com.openwes.opsflow.message;

/**
 *
 * @author xuanloc0511@gmail.com
 */
public class LoginMessage {

    private String barcode;
    private String username;
    private String password;

    public LoginMessage setBarcode(String barcode) {
        this.barcode = barcode;
        return this;
    }

    public LoginMessage setPassword(String password) {
        this.password = password;
        return this;
    }

    public LoginMessage setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

}
