package com.commsen.liferay.examples.portlet.servicebuilder.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="PlayerLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.commsen.liferay.examples.portlet.servicebuilder.service.impl.PlayerLocalServiceImpl</code>.
 * Modify methods in that class and rerun ServiceBuilder to populate this class
 * and all other generated classes.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.commsen.liferay.examples.portlet.servicebuilder.service.PlayerLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface PlayerLocalService {
    public com.commsen.liferay.examples.portlet.servicebuilder.model.Player addPlayer(
        com.commsen.liferay.examples.portlet.servicebuilder.model.Player player)
        throws com.liferay.portal.SystemException;

    public com.commsen.liferay.examples.portlet.servicebuilder.model.Player createPlayer(
        long playerId);

    public void deletePlayer(long playerId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePlayer(
        com.commsen.liferay.examples.portlet.servicebuilder.model.Player player)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.commsen.liferay.examples.portlet.servicebuilder.model.Player getPlayer(
        long playerId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.commsen.liferay.examples.portlet.servicebuilder.model.Player> getPlayers(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getPlayersCount() throws com.liferay.portal.SystemException;

    public com.commsen.liferay.examples.portlet.servicebuilder.model.Player updatePlayer(
        com.commsen.liferay.examples.portlet.servicebuilder.model.Player player)
        throws com.liferay.portal.SystemException;

    public com.commsen.liferay.examples.portlet.servicebuilder.model.Player updatePlayer(
        com.commsen.liferay.examples.portlet.servicebuilder.model.Player player,
        boolean merge) throws com.liferay.portal.SystemException;

    public void addPlayer(java.lang.String name, boolean active, int score,
        java.util.Date birthday, java.lang.String desc)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.commsen.liferay.examples.portlet.servicebuilder.model.Player> getAllPlayers()
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
