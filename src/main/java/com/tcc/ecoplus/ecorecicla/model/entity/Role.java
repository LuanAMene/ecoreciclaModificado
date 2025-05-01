package com.tcc.ecoplus.ecorecicla.model.entity;

import static com.tcc.ecoplus.ecorecicla.model.entity.Permission.*;

import java.util.Set;

public enum Role {

    ADMIN(
            Set.of(
                    ADMIN_READ,
                    ADMIN_UPDATE,
                    ADMIN_CREATE,
                    ADMIN_DELETE,
                    DESTINADORA_READ,
                    DESTINADORA_UPDATE,
                    DESTINADORA_CREATE,
                    DESTINADORA_DELETE,
                    GERADORA_READ,
                    GERADORA_CREATE,
                    GERADORA_UPDATE,
                    GERADORA_DELETE

            )
    ),

    DESTINADORA(
            Set.of(
                    DESTINADORA_READ,
                    DESTINADORA_UPDATE,
                    DESTINADORA_CREATE,
                    DESTINADORA_DELETE
            )
    ),
    GERADORA(
            Set.of(
                    GERADORA_READ,
                    GERADORA_CREATE,
                    GERADORA_UPDATE,
                    GERADORA_DELETE
                    )
    );


    private Set<Permission> permissions;
    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }
    public Set<Permission> getPermissions() {
        return permissions;
    }

}
