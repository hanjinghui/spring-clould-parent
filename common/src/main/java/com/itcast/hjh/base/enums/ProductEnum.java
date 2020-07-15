package com.itcast.hjh.base.enums;

import lombok.Getter;

@Getter
public enum  ProductEnum {

    UP(1,"上架"),
    DOWN(0,"下架"),
    ;

    private Integer code;
    private String mesg;

    ProductEnum(Integer code, String mesg) {
        this.code = code;
        this.mesg = mesg;
    }
}
