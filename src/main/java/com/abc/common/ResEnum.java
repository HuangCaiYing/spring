package com.abc.common;

public enum ResEnum {
    SUCCESS(200,"success"),
    SUCCESS_USER_EXIST(201,"user exist success"),
    SUCCESS_DEL_BATCH(202,"delete batch success"),
    ERROR_USER_EXIST(501,"user exist error"),
    ERROR(500,"error"),
    ERROR_PARAMS_IN_DELBATCH(501,"param can't be null");
    private  int status;
    private String mgs;

    ResEnum(int status, String mgs) {
        this.status = status;
        this.mgs = mgs;
    }

    public int getStatus() {
        return status;
    }

    public String getMgs() {
        return mgs;
    }
}
