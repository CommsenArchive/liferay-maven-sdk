package com.commsen.liferay.examples.portlet.servicebuilder.service.persistence;

import com.commsen.liferay.examples.portlet.servicebuilder.NoSuchPlayerException;
import com.commsen.liferay.examples.portlet.servicebuilder.model.Player;
import com.commsen.liferay.examples.portlet.servicebuilder.model.impl.PlayerImpl;
import com.commsen.liferay.examples.portlet.servicebuilder.model.impl.PlayerModelImpl;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistry;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PlayerPersistenceImpl extends BasePersistenceImpl
    implements PlayerPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = PlayerImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_ACTIVEPLAYERS = new FinderPath(PlayerModelImpl.ENTITY_CACHE_ENABLED,
            PlayerModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByActivePlayers", new String[] { Boolean.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_ACTIVEPLAYERS = new FinderPath(PlayerModelImpl.ENTITY_CACHE_ENABLED,
            PlayerModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByActivePlayers",
            new String[] {
                Boolean.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVEPLAYERS = new FinderPath(PlayerModelImpl.ENTITY_CACHE_ENABLED,
            PlayerModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByActivePlayers", new String[] { Boolean.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(PlayerModelImpl.ENTITY_CACHE_ENABLED,
            PlayerModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PlayerModelImpl.ENTITY_CACHE_ENABLED,
            PlayerModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(PlayerPersistenceImpl.class);
    @BeanReference(name = "com.commsen.liferay.examples.portlet.servicebuilder.service.persistence.PlayerPersistence.impl")
    protected com.commsen.liferay.examples.portlet.servicebuilder.service.persistence.PlayerPersistence playerPersistence;

    public void cacheResult(Player player) {
        EntityCacheUtil.putResult(PlayerModelImpl.ENTITY_CACHE_ENABLED,
            PlayerImpl.class, player.getPrimaryKey(), player);
    }

    public void cacheResult(List<Player> players) {
        for (Player player : players) {
            if (EntityCacheUtil.getResult(
                        PlayerModelImpl.ENTITY_CACHE_ENABLED, PlayerImpl.class,
                        player.getPrimaryKey(), this) == null) {
                cacheResult(player);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(PlayerImpl.class.getName());
        EntityCacheUtil.clearCache(PlayerImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public Player create(long playerId) {
        Player player = new PlayerImpl();

        player.setNew(true);
        player.setPrimaryKey(playerId);

        return player;
    }

    public Player remove(long playerId)
        throws NoSuchPlayerException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Player player = (Player) session.get(PlayerImpl.class,
                    new Long(playerId));

            if (player == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No Player exists with the primary key " +
                        playerId);
                }

                throw new NoSuchPlayerException(
                    "No Player exists with the primary key " + playerId);
            }

            return remove(player);
        } catch (NoSuchPlayerException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public Player remove(Player player) throws SystemException {
        for (ModelListener<Player> listener : listeners) {
            listener.onBeforeRemove(player);
        }

        player = removeImpl(player);

        for (ModelListener<Player> listener : listeners) {
            listener.onAfterRemove(player);
        }

        return player;
    }

    protected Player removeImpl(Player player) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (player.isCachedModel() || BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(PlayerImpl.class,
                        player.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(player);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(PlayerModelImpl.ENTITY_CACHE_ENABLED,
            PlayerImpl.class, player.getPrimaryKey());

        return player;
    }

    /**
     * @deprecated Use <code>update(Player player, boolean merge)</code>.
     */
    public Player update(Player player) throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(Player player) method. Use update(Player player, boolean merge) instead.");
        }

        return update(player, false);
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
    public Player update(Player player, boolean merge)
        throws SystemException {
        boolean isNew = player.isNew();

        for (ModelListener<Player> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(player);
            } else {
                listener.onBeforeUpdate(player);
            }
        }

        player = updateImpl(player, merge);

        for (ModelListener<Player> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(player);
            } else {
                listener.onAfterUpdate(player);
            }
        }

        return player;
    }

    public Player updateImpl(
        com.commsen.liferay.examples.portlet.servicebuilder.model.Player player,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, player, merge);

            player.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(PlayerModelImpl.ENTITY_CACHE_ENABLED,
            PlayerImpl.class, player.getPrimaryKey(), player);

        return player;
    }

    public Player findByPrimaryKey(long playerId)
        throws NoSuchPlayerException, SystemException {
        Player player = fetchByPrimaryKey(playerId);

        if (player == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No Player exists with the primary key " + playerId);
            }

            throw new NoSuchPlayerException(
                "No Player exists with the primary key " + playerId);
        }

        return player;
    }

    public Player fetchByPrimaryKey(long playerId) throws SystemException {
        Player player = (Player) EntityCacheUtil.getResult(PlayerModelImpl.ENTITY_CACHE_ENABLED,
                PlayerImpl.class, playerId, this);

        if (player == null) {
            Session session = null;

            try {
                session = openSession();

                player = (Player) session.get(PlayerImpl.class,
                        new Long(playerId));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (player != null) {
                    cacheResult(player);
                }

                closeSession(session);
            }
        }

        return player;
    }

    public List<Player> findByActivePlayers(boolean active)
        throws SystemException {
        Object[] finderArgs = new Object[] { Boolean.valueOf(active) };

        List<Player> list = (List<Player>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ACTIVEPLAYERS,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.commsen.liferay.examples.portlet.servicebuilder.model.Player WHERE ");

                query.append("active_ = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("name ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(active);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Player>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ACTIVEPLAYERS,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<Player> findByActivePlayers(boolean active, int start, int end)
        throws SystemException {
        return findByActivePlayers(active, start, end, null);
    }

    public List<Player> findByActivePlayers(boolean active, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                Boolean.valueOf(active),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<Player> list = (List<Player>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ACTIVEPLAYERS,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.commsen.liferay.examples.portlet.servicebuilder.model.Player WHERE ");

                query.append("active_ = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("name ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(active);

                list = (List<Player>) QueryUtil.list(q, getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Player>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ACTIVEPLAYERS,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public Player findByActivePlayers_First(boolean active,
        OrderByComparator obc) throws NoSuchPlayerException, SystemException {
        List<Player> list = findByActivePlayers(active, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Player exists with the key {");

            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPlayerException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Player findByActivePlayers_Last(boolean active, OrderByComparator obc)
        throws NoSuchPlayerException, SystemException {
        int count = countByActivePlayers(active);

        List<Player> list = findByActivePlayers(active, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Player exists with the key {");

            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPlayerException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Player[] findByActivePlayers_PrevAndNext(long playerId,
        boolean active, OrderByComparator obc)
        throws NoSuchPlayerException, SystemException {
        Player player = findByPrimaryKey(playerId);

        int count = countByActivePlayers(active);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.commsen.liferay.examples.portlet.servicebuilder.model.Player WHERE ");

            query.append("active_ = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("name ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(active);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, player);

            Player[] array = new PlayerImpl[3];

            array[0] = (Player) objArray[0];
            array[1] = (Player) objArray[1];
            array[2] = (Player) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Object> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            dynamicQuery.compile(session);

            return dynamicQuery.list();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Object> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            dynamicQuery.setLimit(start, end);

            dynamicQuery.compile(session);

            return dynamicQuery.list();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Player> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<Player> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    public List<Player> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<Player> list = (List<Player>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.commsen.liferay.examples.portlet.servicebuilder.model.Player ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("name ASC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<Player>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<Player>) QueryUtil.list(q, getDialect(),
                            start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Player>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByActivePlayers(boolean active) throws SystemException {
        for (Player player : findByActivePlayers(active)) {
            remove(player);
        }
    }

    public void removeAll() throws SystemException {
        for (Player player : findAll()) {
            remove(player);
        }
    }

    public int countByActivePlayers(boolean active) throws SystemException {
        Object[] finderArgs = new Object[] { Boolean.valueOf(active) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ACTIVEPLAYERS,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.commsen.liferay.examples.portlet.servicebuilder.model.Player WHERE ");

                query.append("active_ = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(active);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ACTIVEPLAYERS,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countAll() throws SystemException {
        Object[] finderArgs = new Object[0];

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(
                        "SELECT COUNT(*) FROM com.commsen.liferay.examples.portlet.servicebuilder.model.Player");

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL, finderArgs,
                    count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.commsen.liferay.examples.portlet.servicebuilder.model.Player")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Player>> listenersList = new ArrayList<ModelListener<Player>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Player>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
