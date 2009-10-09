package com.commsen.liferay.examples.portlet.servicebuilder.model;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;


public class PlayerClp extends BaseModelImpl<Player> implements Player {
    private long _playerId;
    private String _name;
    private boolean _active;
    private int _score;
    private Date _birthday;
    private String _description;

    public PlayerClp() {
    }

    public long getPrimaryKey() {
        return _playerId;
    }

    public void setPrimaryKey(long pk) {
        setPlayerId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_playerId);
    }

    public long getPlayerId() {
        return _playerId;
    }

    public void setPlayerId(long playerId) {
        _playerId = playerId;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public boolean getActive() {
        return _active;
    }

    public boolean isActive() {
        return _active;
    }

    public void setActive(boolean active) {
        _active = active;
    }

    public int getScore() {
        return _score;
    }

    public void setScore(int score) {
        _score = score;
    }

    public Date getBirthday() {
        return _birthday;
    }

    public void setBirthday(Date birthday) {
        _birthday = birthday;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public Player toEscapedModel() {
        if (isEscapedModel()) {
            return this;
        } else {
            Player model = new PlayerClp();

            model.setEscapedModel(true);

            model.setPlayerId(getPlayerId());
            model.setName(HtmlUtil.escape(getName()));
            model.setActive(getActive());
            model.setScore(getScore());
            model.setBirthday(getBirthday());
            model.setDescription(HtmlUtil.escape(getDescription()));

            model = (Player) Proxy.newProxyInstance(Player.class.getClassLoader(),
                    new Class[] { Player.class }, new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PlayerClp clone = new PlayerClp();

        clone.setPlayerId(getPlayerId());
        clone.setName(getName());
        clone.setActive(getActive());
        clone.setScore(getScore());
        clone.setBirthday(getBirthday());
        clone.setDescription(getDescription());

        return clone;
    }

    public int compareTo(Player player) {
        int value = 0;

        value = getName().compareTo(player.getName());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        PlayerClp player = null;

        try {
            player = (PlayerClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = player.getPrimaryKey();

        if (getPrimaryKey() == pk) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (int) getPrimaryKey();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("{playerId=");
        sb.append(getPlayerId());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", active=");
        sb.append(getActive());
        sb.append(", score=");
        sb.append(getScore());
        sb.append(", birthday=");
        sb.append(getBirthday());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<model><model-name>");
        sb.append(
            "com.commsen.liferay.examples.portlet.servicebuilder.model.Player");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>playerId</column-name><column-value><![CDATA[");
        sb.append(getPlayerId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>active</column-name><column-value><![CDATA[");
        sb.append(getActive());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>score</column-name><column-value><![CDATA[");
        sb.append(getScore());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>birthday</column-name><column-value><![CDATA[");
        sb.append(getBirthday());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
