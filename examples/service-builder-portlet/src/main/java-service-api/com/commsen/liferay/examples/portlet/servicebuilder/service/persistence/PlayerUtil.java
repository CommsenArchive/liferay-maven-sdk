package com.commsen.liferay.examples.portlet.servicebuilder.service.persistence;

public class PlayerUtil {
    private static PlayerPersistence _persistence;

    public static void cacheResult(
        com.commsen.liferay.examples.portlet.servicebuilder.model.Player player) {
        getPersistence().cacheResult(player);
    }

    public static void cacheResult(
        java.util.List<com.commsen.liferay.examples.portlet.servicebuilder.model.Player> players) {
        getPersistence().cacheResult(players);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.commsen.liferay.examples.portlet.servicebuilder.model.Player create(
        long playerId) {
        return getPersistence().create(playerId);
    }

    public static com.commsen.liferay.examples.portlet.servicebuilder.model.Player remove(
        long playerId)
        throws com.commsen.liferay.examples.portlet.servicebuilder.NoSuchPlayerException,
            com.liferay.portal.SystemException {
        return getPersistence().remove(playerId);
    }

    public static com.commsen.liferay.examples.portlet.servicebuilder.model.Player remove(
        com.commsen.liferay.examples.portlet.servicebuilder.model.Player player)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(player);
    }

    /**
     * @deprecated Use <code>update(Player player, boolean merge)</code>.
     */
    public static com.commsen.liferay.examples.portlet.servicebuilder.model.Player update(
        com.commsen.liferay.examples.portlet.servicebuilder.model.Player player)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(player);
    }

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
    public static com.commsen.liferay.examples.portlet.servicebuilder.model.Player update(
        com.commsen.liferay.examples.portlet.servicebuilder.model.Player player,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(player, merge);
    }

    public static com.commsen.liferay.examples.portlet.servicebuilder.model.Player updateImpl(
        com.commsen.liferay.examples.portlet.servicebuilder.model.Player player,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(player, merge);
    }

    public static com.commsen.liferay.examples.portlet.servicebuilder.model.Player findByPrimaryKey(
        long playerId)
        throws com.commsen.liferay.examples.portlet.servicebuilder.NoSuchPlayerException,
            com.liferay.portal.SystemException {
        return getPersistence().findByPrimaryKey(playerId);
    }

    public static com.commsen.liferay.examples.portlet.servicebuilder.model.Player fetchByPrimaryKey(
        long playerId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(playerId);
    }

    public static java.util.List<com.commsen.liferay.examples.portlet.servicebuilder.model.Player> findByActivePlayers(
        boolean active) throws com.liferay.portal.SystemException {
        return getPersistence().findByActivePlayers(active);
    }

    public static java.util.List<com.commsen.liferay.examples.portlet.servicebuilder.model.Player> findByActivePlayers(
        boolean active, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByActivePlayers(active, start, end);
    }

    public static java.util.List<com.commsen.liferay.examples.portlet.servicebuilder.model.Player> findByActivePlayers(
        boolean active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByActivePlayers(active, start, end, obc);
    }

    public static com.commsen.liferay.examples.portlet.servicebuilder.model.Player findByActivePlayers_First(
        boolean active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.commsen.liferay.examples.portlet.servicebuilder.NoSuchPlayerException,
            com.liferay.portal.SystemException {
        return getPersistence().findByActivePlayers_First(active, obc);
    }

    public static com.commsen.liferay.examples.portlet.servicebuilder.model.Player findByActivePlayers_Last(
        boolean active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.commsen.liferay.examples.portlet.servicebuilder.NoSuchPlayerException,
            com.liferay.portal.SystemException {
        return getPersistence().findByActivePlayers_Last(active, obc);
    }

    public static com.commsen.liferay.examples.portlet.servicebuilder.model.Player[] findByActivePlayers_PrevAndNext(
        long playerId, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.commsen.liferay.examples.portlet.servicebuilder.NoSuchPlayerException,
            com.liferay.portal.SystemException {
        return getPersistence()
                   .findByActivePlayers_PrevAndNext(playerId, active, obc);
    }

    public static java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    public static java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    public static java.util.List<com.commsen.liferay.examples.portlet.servicebuilder.model.Player> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.commsen.liferay.examples.portlet.servicebuilder.model.Player> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.commsen.liferay.examples.portlet.servicebuilder.model.Player> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByActivePlayers(boolean active)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByActivePlayers(active);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByActivePlayers(boolean active)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByActivePlayers(active);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static PlayerPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PlayerPersistence persistence) {
        _persistence = persistence;
    }
}
