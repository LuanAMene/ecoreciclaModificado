package com.tcc.ecoplus.ecorecicla.model.entity;

public enum Permission {

    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),

    GERADORA_READ("representantecoletora:read"),
    GERADORA_UPDATE("representantecoletora:update"),
    GERADORA_CREATE("representantecoletora:create"),
    GERADORA_DELETE("representantecoletora:delete"),

    DESTINADORA_READ("representantedestinadora:read"),
    DESTINADORA_UPDATE("representantedestinadora:update"),
    DESTINADORA_CREATE("representantedestinadora:create"),
    DESTINADORA_DELETE("representantedestinadora:delete");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
