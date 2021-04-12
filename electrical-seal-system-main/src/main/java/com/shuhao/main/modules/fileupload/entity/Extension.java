package com.shuhao.main.modules.fileupload.entity;

/**
 * PKCS12证书
 */
public class Extension {

    private String oid;

    private boolean critical;

    private byte[] value;

    public String getOid() {
        return oid;
    }

    public byte[] getValue() {
        return value;
    }
    public boolean isCritical() {
        return critical;
    }
}