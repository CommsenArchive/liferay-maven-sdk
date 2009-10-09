package com.commsen.liferay.examples.portlet.servicebuilder.service.base;

import com.commsen.liferay.examples.portlet.servicebuilder.service.PlayerLocalService;
import com.commsen.liferay.examples.portlet.servicebuilder.service.PlayerService;
import com.commsen.liferay.examples.portlet.servicebuilder.service.persistence.PlayerPersistence;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.util.PortalUtil;


public abstract class PlayerServiceBaseImpl extends PrincipalBean
    implements PlayerService {
    @BeanReference(name = "com.commsen.liferay.examples.portlet.servicebuilder.service.PlayerLocalService.impl")
    protected PlayerLocalService playerLocalService;
    @BeanReference(name = "com.commsen.liferay.examples.portlet.servicebuilder.service.PlayerService.impl")
    protected PlayerService playerService;
    @BeanReference(name = "com.commsen.liferay.examples.portlet.servicebuilder.service.persistence.PlayerPersistence.impl")
    protected PlayerPersistence playerPersistence;

    public PlayerLocalService getPlayerLocalService() {
        return playerLocalService;
    }

    public void setPlayerLocalService(PlayerLocalService playerLocalService) {
        this.playerLocalService = playerLocalService;
    }

    public PlayerService getPlayerService() {
        return playerService;
    }

    public void setPlayerService(PlayerService playerService) {
        this.playerService = playerService;
    }

    public PlayerPersistence getPlayerPersistence() {
        return playerPersistence;
    }

    public void setPlayerPersistence(PlayerPersistence playerPersistence) {
        this.playerPersistence = playerPersistence;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
