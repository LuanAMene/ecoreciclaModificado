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
                    REPRESENTANTEDESTINADORA_READ,
                    REPRESENTANTEDESTINADORA_UPDATE,
                    REPRESENTANTEDESTINADORA_CREATE,
                    REPRESENTANTEDESTINADORA_DELETE,
                    REPRESENTANTECOLETA_READ,
                    REPRESENTANTECOLETA_CREATE,
                    REPRESENTANTECOLETA_UPDATE,
                    REPRESENTANTECOLETA_DELETE

            )
    ),

    REPRESENTANTEDESTINADORA(
            Set.of(
                    REPRESENTANTEDESTINADORA_READ,
                    REPRESENTANTEDESTINADORA_UPDATE,
                    REPRESENTANTEDESTINADORA_CREATE,
                    REPRESENTANTEDESTINADORA_DELETE
            )
    ),
    REPRESENTANTECOLETORA(
            Set.of(
                    REPRESENTANTECOLETA_READ,
                    REPRESENTANTECOLETA_CREATE,
                    REPRESENTANTECOLETA_UPDATE,
                    REPRESENTANTECOLETA_DELETE
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
