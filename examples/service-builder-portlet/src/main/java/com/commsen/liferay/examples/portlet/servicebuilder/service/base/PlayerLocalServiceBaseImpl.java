package com.commsen.liferay.examples.portlet.servicebuilder.service.base;

import com.commsen.liferay.examples.portlet.servicebuilder.model.Player;
import com.commsen.liferay.examples.portlet.servicebuilder.service.PlayerLocalService;
import com.commsen.liferay.examples.portlet.servicebuilder.service.PlayerService;
import com.commsen.liferay.examples.portlet.servicebuilder.service.persistence.PlayerPersistence;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.util.PortalUtil;

import java.util.List;


public abstract class PlayerLocalServiceBaseImpl implements PlayerLocalService {
    @BeanReference(name = "com.commsen.liferay.examples.portlet.servicebuilder.service.PlayerLocalService.impl")
    protected PlayerLocalService playerLocalService;
    @BeanReference(name = "com.commsen.liferay.examples.portlet.servicebuilder.service.PlayerService.impl")
    protected PlayerService playerService;
    @BeanReference(name = "com.commsen.liferay.examples.portlet.servicebuilder.service.persistence.PlayerPersistence.impl")
    protected PlayerPersistence playerPersistence;

    public Player addPlayer(Player player) throws SystemException {
        player.setNew(true);

        return playerPersistence.update(player, false);
    }

    public Player createPlayer(long playerId) {
        return playerPersistence.create(playerId);
    }

    public void deletePlayer(long playerId)
        throws PortalException, SystemException {
        playerPersistence.remove(playerId);
    }

    public void deletePlayer(Player player) throws SystemException {
        playerPersistence.remove(player);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return playerPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return playerPersistence.findWithDynamicQuery(dynamicQuery, start, end);
    }

    public Player getPlayer(long playerId)
        throws PortalException, SystemException {
        return playerPersistence.findByPrimaryKey(playerId);
    }

    public List<Player> getPlayers(int start, int end)
        throws SystemException {
        return playerPersistence.findAll(start, end);
    }

    public int getPlayersCount() throws SystemException {
        return playerPersistence.countAll();
    }

    public Player updatePlayer(Player player) throws SystemException {
        player.setNew(false);

        return playerPersistence.update(player, true);
    }

    public Player updatePlayer(Player player, boolean merge)
        throws SystemException {
        player.setNew(false);

        return playerPersistence.update(player, merge);
    }

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
