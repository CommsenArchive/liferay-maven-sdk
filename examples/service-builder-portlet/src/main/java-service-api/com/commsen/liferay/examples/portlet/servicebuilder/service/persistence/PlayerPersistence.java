package com.commsen.liferay.examples.portlet.servicebuilder.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface PlayerPersistence extends BasePersistence {
    public void cacheResult(
        com.commsen.liferay.examples.portlet.servicebuilder.model.Player player);

    public void cacheResult(
        java.util.List<com.commsen.liferay.examples.portlet.servicebuilder.model.Player> players);

    public void clearCache();

    public com.commsen.liferay.examples.portlet.servicebuilder.model.Player create(
        long playerId);

    public com.commsen.liferay.examples.portlet.servicebuilder.model.Player remove(
        long playerId)
        throws com.commsen.liferay.examples.portlet.servicebuilder.NoSuchPlayerException,
            com.liferay.portal.SystemException;

    public com.commsen.liferay.examples.portlet.servicebuilder.model.Player remove(
        com.commsen.liferay.examples.portlet.servicebuilder.model.Player player)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(Player player, boolean merge)</code>.
     */
    public com.commsen.liferay.examples.portlet.servicebuilder.model.Player update(
        com.commsen.liferay.examples.portlet.servicebuilder.model.Player player)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                player the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when player is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.commsen.liferay.examples.portlet.servicebuilder.model.Player update(
        com.commsen.liferay.examples.portlet.servicebuilder.model.Player player,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.commsen.liferay.examples.portlet.servicebuilder.model.Player updateImpl(
        com.commsen.liferay.examples.portlet.servicebuilder.model.Player player,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.commsen.liferay.examples.portlet.servicebuilder.model.Player findByPrimaryKey(
        long playerId)
        throws com.commsen.liferay.examples.portlet.servicebuilder.NoSuchPlayerException,
            com.liferay.portal.SystemException;

    public com.commsen.liferay.examples.portlet.servicebuilder.model.Player fetchByPrimaryKey(
        long playerId) throws com.liferay.portal.SystemException;

    public java.util.List<com.commsen.liferay.examples.portlet.servicebuilder.model.Player> findByActivePlayers(
        boolean active) throws com.liferay.portal.SystemException;

    public java.util.List<com.commsen.liferay.examples.portlet.servicebuilder.model.Player> findByActivePlayers(
        boolean active, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.commsen.liferay.examples.portlet.servicebuilder.model.Player> findByActivePlayers(
        boolean active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.commsen.liferay.examples.portlet.servicebuilder.model.Player findByActivePlayers_First(
        boolean active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.commsen.liferay.examples.portlet.servicebuilder.NoSuchPlayerException,
            com.liferay.portal.SystemException;

    public com.commsen.liferay.examples.portlet.servicebuilder.model.Player findByActivePlayers_Last(
        boolean active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.commsen.liferay.examples.portlet.servicebuilder.NoSuchPlayerException,
            com.liferay.portal.SystemException;

    public com.commsen.liferay.examples.portlet.servicebuilder.model.Player[] findByActivePlayers_PrevAndNext(
        long playerId, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.commsen.liferay.examples.portlet.servicebuilder.NoSuchPlayerException,
            com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.commsen.liferay.examples.portlet.servicebuilder.model.Player> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.commsen.liferay.examples.portlet.servicebuilder.model.Player> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.commsen.liferay.examples.portlet.servicebuilder.model.Player> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByActivePlayers(boolean active)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByActivePlayers(boolean active)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
