package com.commsen.liferay.examples.portlet.servicebuilder.model.impl;

import com.commsen.liferay.examples.portlet.servicebuilder.model.Player;
import com.commsen.liferay.examples.portlet.servicebuilder.model.PlayerSoap;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PlayerModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>Player</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.commsen.liferay.examples.portlet.servicebuilder.model.Player
 * @see com.commsen.liferay.examples.portlet.servicebuilder.model.PlayerModel
 * @see com.commsen.liferay.examples.portlet.servicebuilder.model.impl.PlayerImpl
 *
 */
public class PlayerModelImpl extends BaseModelImpl<Player> {
    public static final String TABLE_NAME = "SB_Player";
    public static final Object[][] TABLE_COLUMNS = {
            { "playerId", new Integer(Types.BIGINT) },
            

            { "name", new Integer(Types.VARCHAR) },
            

            { "active_", new Integer(Types.BOOLEAN) },
            

            { "score", new Integer(Types.INTEGER) },
            

            { "birthday", new Integer(Types.TIMESTAMP) },
            

            { "description", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table SB_Player (playerId LONG not null primary key,name VARCHAR(75) null,active_ BOOLEAN,score INTEGER,birthday DATE null,description VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table SB_Player";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.commsen.liferay.examples.portlet.servicebuilder.model.Player"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.commsen.liferay.examples.portlet.servicebuilder.model.Player"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.commsen.liferay.examples.portlet.servicebuilder.model.Player"));
    private long _playerId;
    private String _name;
    private boolean _active;
    private int _score;
    private Date _birthday;
    private String _description;
    private transient ExpandoBridge _expandoBridge;

    public PlayerModelImpl() {
    }

    public static Player toModel(PlayerSoap soapModel) {
        Player model = new PlayerImpl();

        model.setPlayerId(soapModel.getPlayerId());
        model.setName(soapModel.getName());
        model.setActive(soapModel.getActive());
        model.setScore(soapModel.getScore());
        model.setBirthday(soapModel.getBirthday());
        model.setDescription(soapModel.getDescription());

        return model;
    }

    public static List<Player> toModels(PlayerSoap[] soapModels) {
        List<Player> models = new ArrayList<Player>(soapModels.length);

        for (PlayerSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
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
        return GetterUtil.getString(_name);
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
        return GetterUtil.getString(_description);
    }

    public void setDescription(String description) {
        _description = description;
    }

    public Player toEscapedModel() {
        if (isEscapedModel()) {
            return (Player) this;
        } else {
            Player model = new PlayerImpl();

            model.setNew(isNew());
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

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(Player.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
    }

    public Object clone() {
        PlayerImpl clone = new PlayerImpl();

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

        Player player = null;

        try {
            player = (Player) obj;
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
