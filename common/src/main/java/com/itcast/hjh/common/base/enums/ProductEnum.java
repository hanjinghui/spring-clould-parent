package com.itcast.hjh.common.base.enums;

import lombok.Getter;

@Getter
public enum  ProductEnum {

    UP("1","上架"),
    DOWN("2","下架"),
    ;

    private String code;
    private String mesg;

    ProductEnum(String code, String mesg) {
        this.code = code;
        this.mesg = mesg;
    }
}
