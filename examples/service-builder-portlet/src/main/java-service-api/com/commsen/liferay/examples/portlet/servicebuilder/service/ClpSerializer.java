package com.commsen.liferay.examples.portlet.servicebuilder.service;

import com.commsen.liferay.examples.portlet.servicebuilder.model.PlayerClp;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.BaseModel;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ClpSerializer {
    public static final String SERVLET_CONTEXT_NAME = "service-builder-portlet";
    private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
    private static ClassLoader _classLoader;

    public static void setClassLoader(ClassLoader classLoader) {
        _classLoader = classLoader;
    }

    public static Object translateInput(BaseModel oldModel) {
        Class<?> oldModelClass = oldModel.getClass();

        String oldModelClassName = oldModelClass.getName();

        if (oldModelClassName.equals(PlayerClp.class.getName())) {
            PlayerClp oldCplModel = (PlayerClp) oldModel;

            ClassLoader contextClassLoader = Thread.currentThread()
                                                   .getContextClassLoader();

            try {
                Thread.currentThread().setContextClassLoader(_classLoader);

                try {
                    Class<?> newModelClass = Class.forName("com.commsen.liferay.examples.portlet.servicebuilder.model.impl.PlayerImpl",
                            true, _classLoader);

                    Object newModel = newModelClass.newInstance();

                    Method method0 = newModelClass.getMethod("setPlayerId",
                            new Class[] { Long.TYPE });

                    Long value0 = new Long(oldCplModel.getPlayerId());

                    method0.invoke(newModel, value0);

                    Method method1 = newModelClass.getMethod("setName",
                            new Class[] { String.class });

                    String value1 = oldCplModel.getName();

                    method1.invoke(newModel, value1);

                    Method method2 = newModelClass.getMethod("setActive",
                            new Class[] { Boolean.TYPE });

                    Boolean value2 = new Boolean(oldCplModel.getActive());

                    method2.invoke(newModel, value2);

                    Method method3 = newModelClass.getMethod("setScore",
                            new Class[] { Integer.TYPE });

                    Integer value3 = new Integer(oldCplModel.getScore());

                    method3.invoke(newModel, value3);

                    Method method4 = newModelClass.getMethod("setBirthday",
                            new Class[] { Date.class });

                    Date value4 = oldCplModel.getBirthday();

                    method4.invoke(newModel, value4);

                    Method method5 = newModelClass.getMethod("setDescription",
                            new Class[] { String.class });

                    String value5 = oldCplModel.getDescription();

                    method5.invoke(newModel, value5);

                    return newModel;
                } catch (Exception e) {
                    _log.error(e, e);
                }
            } finally {
                Thread.currentThread().setContextClassLoader(contextClassLoader);
            }
        }

        return oldModel;
    }

    public static Object translateInput(List<Object> oldList) {
        List<Object> newList = new ArrayList<Object>(oldList.size());

        for (int i = 0; i < oldList.size(); i++) {
            Object curObj = oldList.get(i);

            newList.add(translateInput(curObj));
        }

        return newList;
    }

    public static Object translateInput(Object obj) {
        if (obj instanceof BaseModel) {
            return translateInput((BaseModel) obj);
        } else if (obj instanceof List) {
            return translateInput((List<Object>) obj);
        } else {
            return obj;
        }
    }

    public static Object translateOutput(BaseModel oldModel) {
        Class<?> oldModelClass = oldModel.getClass();

        String oldModelClassName = oldModelClass.getName();

        if (oldModelClassName.equals(
                    "com.commsen.liferay.examples.portlet.servicebuilder.model.impl.PlayerImpl")) {
            ClassLoader contextClassLoader = Thread.currentThread()
                                                   .getContextClassLoader();

            try {
                Thread.currentThread().setContextClassLoader(_classLoader);

                try {
                    PlayerClp newModel = new PlayerClp();

                    Method method0 = oldModelClass.getMethod("getPlayerId");

                    Long value0 = (Long) method0.invoke(oldModel,
                            (Object[]) null);

                    newModel.setPlayerId(value0.longValue());

                    Method method1 = oldModelClass.getMethod("getName");

                    String value1 = (String) method1.invoke(oldModel,
                            (Object[]) null);

                    newModel.setName(value1);

                    Method method2 = oldModelClass.getMethod("getActive");

                    Boolean value2 = (Boolean) method2.invoke(oldModel,
                            (Object[]) null);

                    newModel.setActive(value2.booleanValue());

                    Method method3 = oldModelClass.getMethod("getScore");

                    Integer value3 = (Integer) method3.invoke(oldModel,
                            (Object[]) null);

                    newModel.setScore(value3.intValue());

                    Method method4 = oldModelClass.getMethod("getBirthday");

                    Date value4 = (Date) method4.invoke(oldModel,
                            (Object[]) null);

                    newModel.setBirthday(value4);

                    Method method5 = oldModelClass.getMethod("getDescription");

                    String value5 = (String) method5.invoke(oldModel,
                            (Object[]) null);

                    newModel.setDescription(value5);

                    return newModel;
                } catch (Exception e) {
                    _log.error(e, e);
                }
            } finally {
                Thread.currentThread().setContextClassLoader(contextClassLoader);
            }
        }

        return oldModel;
    }

    public static Object translateOutput(List<Object> oldList) {
        List<Object> newList = new ArrayList<Object>(oldList.size());

        for (int i = 0; i < oldList.size(); i++) {
            Object curObj = oldList.get(i);

            newList.add(translateOutput(curObj));
        }

        return newList;
    }

    public static Object translateOutput(Object obj) {
        if (obj instanceof BaseModel) {
            return translateOutput((BaseModel) obj);
        } else if (obj instanceof List) {
            return translateOutput((List<Object>) obj);
        } else {
            return obj;
        }
    }
}
