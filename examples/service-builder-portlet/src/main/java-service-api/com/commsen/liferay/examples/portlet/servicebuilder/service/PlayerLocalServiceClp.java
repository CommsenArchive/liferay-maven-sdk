package com.commsen.liferay.examples.portlet.servicebuilder.service;

import com.liferay.portal.kernel.util.BooleanWrapper;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.LongWrapper;
import com.liferay.portal.kernel.util.NullWrapper;


public class PlayerLocalServiceClp implements PlayerLocalService {
    private ClassLoaderProxy _classLoaderProxy;

    public PlayerLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
        _classLoaderProxy = classLoaderProxy;
    }

    public com.commsen.liferay.examples.portlet.servicebuilder.model.Player addPlayer(
        com.commsen.liferay.examples.portlet.servicebuilder.model.Player player)
        throws com.liferay.portal.SystemException {
        Object paramObj0 = ClpSerializer.translateInput(player);

        if (player == null) {
            paramObj0 = new NullWrapper(
                    "com.commsen.liferay.examples.portlet.servicebuilder.model.Player");
        }

        Object returnObj = null;

        try {
            returnObj = _classLoaderProxy.invoke("addPlayer",
                    new Object[] { paramObj0 });
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.SystemException) {
                throw (com.liferay.portal.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.commsen.liferay.examples.portlet.servicebuilder.model.Player) ClpSerializer.translateOutput(returnObj);
    }

    public com.commsen.liferay.examples.portlet.servicebuilder.model.Player createPlayer(
        long playerId) {
        Object paramObj0 = new LongWrapper(playerId);

        Object returnObj = null;

        try {
            returnObj = _classLoaderProxy.invoke("createPlayer",
                    new Object[] { paramObj0 });
        } catch (Throwable t) {
            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.commsen.liferay.examples.portlet.servicebuilder.model.Player) ClpSerializer.translateOutput(returnObj);
    }

    public void deletePlayer(long playerId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        Object paramObj0 = new LongWrapper(playerId);

        try {
            _classLoaderProxy.invoke("deletePlayer", new Object[] { paramObj0 });
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.PortalException) {
                throw (com.liferay.portal.PortalException) t;
            }

            if (t instanceof com.liferay.portal.SystemException) {
                throw (com.liferay.portal.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    public void deletePlayer(
        com.commsen.liferay.examples.portlet.servicebuilder.model.Player player)
        throws com.liferay.portal.SystemException {
        Object paramObj0 = ClpSerializer.translateInput(player);

        if (player == null) {
            paramObj0 = new NullWrapper(
                    "com.commsen.liferay.examples.portlet.servicebuilder.model.Player");
        }

        try {
            _classLoaderProxy.invoke("deletePlayer", new Object[] { paramObj0 });
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.SystemException) {
                throw (com.liferay.portal.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException {
        Object paramObj0 = ClpSerializer.translateInput(dynamicQuery);

        if (dynamicQuery == null) {
            paramObj0 = new NullWrapper(
                    "com.liferay.portal.kernel.dao.orm.DynamicQuery");
        }

        Object returnObj = null;

        try {
            returnObj = _classLoaderProxy.invoke("dynamicQuery",
                    new Object[] { paramObj0 });
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.SystemException) {
                throw (com.liferay.portal.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<Object>) ClpSerializer.translateOutput(returnObj);
    }

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException {
        Object paramObj0 = ClpSerializer.translateInput(dynamicQuery);

        if (dynamicQuery == null) {
            paramObj0 = new NullWrapper(
                    "com.liferay.portal.kernel.dao.orm.DynamicQuery");
        }

        Object paramObj1 = new IntegerWrapper(start);

        Object paramObj2 = new IntegerWrapper(end);

        Object returnObj = null;

        try {
            returnObj = _classLoaderProxy.invoke("dynamicQuery",
                    new Object[] { paramObj0, paramObj1, paramObj2 });
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.SystemException) {
                throw (com.liferay.portal.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<Object>) ClpSerializer.translateOutput(returnObj);
    }

    public com.commsen.liferay.examples.portlet.servicebuilder.model.Player getPlayer(
        long playerId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        Object paramObj0 = new LongWrapper(playerId);

        Object returnObj = null;

        try {
            returnObj = _classLoaderProxy.invoke("getPlayer",
                    new Object[] { paramObj0 });
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.PortalException) {
                throw (com.liferay.portal.PortalException) t;
            }

            if (t instanceof com.liferay.portal.SystemException) {
                throw (com.liferay.portal.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.commsen.liferay.examples.portlet.servicebuilder.model.Player) ClpSerializer.translateOutput(returnObj);
    }

    public java.util.List<com.commsen.liferay.examples.portlet.servicebuilder.model.Player> getPlayers(
        int start, int end) throws com.liferay.portal.SystemException {
        Object paramObj0 = new IntegerWrapper(start);

        Object paramObj1 = new IntegerWrapper(end);

        Object returnObj = null;

        try {
            returnObj = _classLoaderProxy.invoke("getPlayers",
                    new Object[] { paramObj0, paramObj1 });
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.SystemException) {
                throw (com.liferay.portal.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<com.commsen.liferay.examples.portlet.servicebuilder.model.Player>) ClpSerializer.translateOutput(returnObj);
    }

    public int getPlayersCount() throws com.liferay.portal.SystemException {
        Object returnObj = null;

        try {
            returnObj = _classLoaderProxy.invoke("getPlayersCount",
                    new Object[0]);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.SystemException) {
                throw (com.liferay.portal.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return ((Integer) returnObj).intValue();
    }

    public com.commsen.liferay.examples.portlet.servicebuilder.model.Player updatePlayer(
        com.commsen.liferay.examples.portlet.servicebuilder.model.Player player)
        throws com.liferay.portal.SystemException {
        Object paramObj0 = ClpSerializer.translateInput(player);

        if (player == null) {
            paramObj0 = new NullWrapper(
                    "com.commsen.liferay.examples.portlet.servicebuilder.model.Player");
        }

        Object returnObj = null;

        try {
            returnObj = _classLoaderProxy.invoke("updatePlayer",
                    new Object[] { paramObj0 });
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.SystemException) {
                throw (com.liferay.portal.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.commsen.liferay.examples.portlet.servicebuilder.model.Player) ClpSerializer.translateOutput(returnObj);
    }

    public com.commsen.liferay.examples.portlet.servicebuilder.model.Player updatePlayer(
        com.commsen.liferay.examples.portlet.servicebuilder.model.Player player,
        boolean merge) throws com.liferay.portal.SystemException {
        Object paramObj0 = ClpSerializer.translateInput(player);

        if (player == null) {
            paramObj0 = new NullWrapper(
                    "com.commsen.liferay.examples.portlet.servicebuilder.model.Player");
        }

        Object paramObj1 = new BooleanWrapper(merge);

        Object returnObj = null;

        try {
            returnObj = _classLoaderProxy.invoke("updatePlayer",
                    new Object[] { paramObj0, paramObj1 });
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.SystemException) {
                throw (com.liferay.portal.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.commsen.liferay.examples.portlet.servicebuilder.model.Player) ClpSerializer.translateOutput(returnObj);
    }

    public void addPlayer(java.lang.String name, boolean active, int score,
        java.util.Date birthday, java.lang.String desc)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        Object paramObj0 = ClpSerializer.translateInput(name);

        if (name == null) {
            paramObj0 = new NullWrapper("java.lang.String");
        }

        Object paramObj1 = new BooleanWrapper(active);

        Object paramObj2 = new IntegerWrapper(score);

        Object paramObj3 = ClpSerializer.translateInput(birthday);

        if (birthday == null) {
            paramObj3 = new NullWrapper("java.util.Date");
        }

        Object paramObj4 = ClpSerializer.translateInput(desc);

        if (desc == null) {
            paramObj4 = new NullWrapper("java.lang.String");
        }

        try {
            _classLoaderProxy.invoke("addPlayer",
                new Object[] {
                    paramObj0, paramObj1, paramObj2, paramObj3, paramObj4
                });
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.PortalException) {
                throw (com.liferay.portal.PortalException) t;
            }

            if (t instanceof com.liferay.portal.SystemException) {
                throw (com.liferay.portal.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    public java.util.List<com.commsen.liferay.examples.portlet.servicebuilder.model.Player> getAllPlayers()
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        Object returnObj = null;

        try {
            returnObj = _classLoaderProxy.invoke("getAllPlayers", new Object[0]);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.PortalException) {
                throw (com.liferay.portal.PortalException) t;
            }

            if (t instanceof com.liferay.portal.SystemException) {
                throw (com.liferay.portal.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<com.commsen.liferay.examples.portlet.servicebuilder.model.Player>) ClpSerializer.translateOutput(returnObj);
    }
}
