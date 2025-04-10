package com.tcc.ecoplus.ecorecicla.model.entity;

public enum Permission {

    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),

    REPRESENTANTECOLETA_READ("representantecoletora:read"),
    REPRESENTANTECOLETA_UPDATE("representantecoletora:update"),
    REPRESENTANTECOLETA_CREATE("representantecoletora:create"),
    REPRESENTANTECOLETA_DELETE("representantecoletora:delete"),

    REPRESENTANTEDESTINADORA_READ("representantedestinadora:read"),
    REPRESENTANTEDESTINADORA_UPDATE("representantedestinadora:update"),
    REPRESENTANTEDESTINADORA_CREATE("representantedestinadora:create"),
    REPRESENTANTEDESTINADORA_DELETE("representantedestinadora:delete");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
