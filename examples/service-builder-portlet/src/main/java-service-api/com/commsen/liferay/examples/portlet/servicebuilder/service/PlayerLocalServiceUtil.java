package com.commsen.liferay.examples.portlet.servicebuilder.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;


/**
 * <a href="PlayerLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.commsen.liferay.examples.portlet.servicebuilder.service.PlayerLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.commsen.liferay.examples.portlet.servicebuilder.service.PlayerLocalService
 *
 */
public class PlayerLocalServiceUtil {
    private static PlayerLocalService _service;

    public static com.commsen.liferay.examples.portlet.servicebuilder.model.Player addPlayer(
        com.commsen.liferay.examples.portlet.servicebuilder.model.Player player)
        throws com.liferay.portal.SystemException {
        return getService().addPlayer(player);
    }

    public static com.commsen.liferay.examples.portlet.servicebuilder.model.Player createPlayer(
        long playerId) {
        return getService().createPlayer(playerId);
    }

    public static void deletePlayer(long playerId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePlayer(playerId);
    }

    public static void deletePlayer(
        com.commsen.liferay.examples.portlet.servicebuilder.model.Player player)
        throws com.liferay.portal.SystemException {
        getService().deletePlayer(player);
    }

    public static java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    public static java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    public static com.commsen.liferay.examples.portlet.servicebuilder.model.Player getPlayer(
        long playerId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPlayer(playerId);
    }

    public static java.util.List<com.commsen.liferay.examples.portlet.servicebuilder.model.Player> getPlayers(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPlayers(start, end);
    }

    public static int getPlayersCount()
        throws com.liferay.portal.SystemException {
        return getService().getPlayersCount();
    }

    public static com.commsen.liferay.examples.portlet.servicebuilder.model.Player updatePlayer(
        com.commsen.liferay.examples.portlet.servicebuilder.model.Player player)
        throws com.liferay.portal.SystemException {
        return getService().updatePlayer(player);
    }

    public static com.commsen.liferay.examples.portlet.servicebuilder.model.Player updatePlayer(
        com.commsen.liferay.examples.portlet.servicebuilder.model.Player player,
        boolean merge) throws com.liferay.portal.SystemException {
        return getService().updatePlayer(player, merge);
    }

    public static void addPlayer(java.lang.String name, boolean active,
        int score, java.util.Date birthday, java.lang.String desc)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().addPlayer(name, active, score, birthday, desc);
    }

    public static java.util.List<com.commsen.liferay.examples.portlet.servicebuilder.model.Player> getAllPlayers()
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getAllPlayers();
    }

    public static void clearService() {
        _service = null;
    }

    public static PlayerLocalService getService() {
        if (_service == null) {
            Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
                    PlayerLocalServiceUtil.class.getName());
            ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
                    "portletClassLoader");

            ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
                    portletClassLoader);

            _service = new PlayerLocalServiceClp(classLoaderProxy);

            ClpSerializer.setClassLoader(portletClassLoader);
        }

        return _service;
    }

    public void setService(PlayerLocalService service) {
        _service = service;
    }
}
