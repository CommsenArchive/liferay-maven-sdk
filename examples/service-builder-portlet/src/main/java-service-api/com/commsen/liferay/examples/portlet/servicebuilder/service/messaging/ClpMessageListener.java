package com.commsen.liferay.examples.portlet.servicebuilder.service.messaging;

import com.commsen.liferay.examples.portlet.servicebuilder.service.ClpSerializer;
import com.commsen.liferay.examples.portlet.servicebuilder.service.PlayerLocalServiceUtil;
import com.commsen.liferay.examples.portlet.servicebuilder.service.PlayerServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;


public class ClpMessageListener implements MessageListener {
    public static final String SERVLET_CONTEXT_NAME = ClpSerializer.SERVLET_CONTEXT_NAME;
    private static Log _log = LogFactoryUtil.getLog(ClpMessageListener.class);

    public void receive(Message message) {
        try {
            doReceive(message);
        } catch (Exception e) {
            _log.error("Unable to process message " + message, e);
        }
    }

    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(SERVLET_CONTEXT_NAME)) {
            PlayerLocalServiceUtil.clearService();

            PlayerServiceUtil.clearService();
        }
    }
}
