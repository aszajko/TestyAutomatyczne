package app.enums;

import lombok.Getter;

public enum  AppUrl {

    FRONT("http://automationpractice.com");

    @Getter
    private String ulr;

    AppUrl(String url) {
    this.ulr = url;
    }

    public String buildUrl(String param) {
       return getUlr().concat(param);
    }

}
