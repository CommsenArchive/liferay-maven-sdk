package com.commsen.liferay.examples.portlet.servicebuilder.service;

import com.liferay.portal.kernel.util.ClassLoaderProxy;


public class PlayerServiceClp implements PlayerService {
    private ClassLoaderProxy _classLoaderProxy;

    public PlayerServiceClp(ClassLoaderProxy classLoaderProxy) {
        _classLoaderProxy = classLoaderProxy;
    }
}
