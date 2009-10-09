package com.commsen.liferay.examples.portlet.servicebuilder.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;


/**
 * <a href="PlayerServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.commsen.liferay.examples.portlet.servicebuilder.service.PlayerService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.commsen.liferay.examples.portlet.servicebuilder.service.PlayerService
 *
 */
public class PlayerServiceUtil {
    private static PlayerService _service;

    public static void clearService() {
        _service = null;
    }

    public static PlayerService getService() {
        if (_service == null) {
            Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
                    PlayerServiceUtil.class.getName());
            ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
                    "portletClassLoader");

            ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
                    portletClassLoader);

            _service = new PlayerServiceClp(classLoaderProxy);

            ClpSerializer.setClassLoader(portletClassLoader);
        }

        return _service;
    }

    public void setService(PlayerService service) {
        _service = service;
    }
}
