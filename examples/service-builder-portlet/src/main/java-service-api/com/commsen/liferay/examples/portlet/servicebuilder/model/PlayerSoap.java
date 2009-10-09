package com.commsen.liferay.examples.portlet.servicebuilder.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PlayerSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.commsen.liferay.examples.portlet.servicebuilder.service.http.PlayerServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.commsen.liferay.examples.portlet.servicebuilder.service.http.PlayerServiceSoap
 *
 */
public class PlayerSoap implements Serializable {
    private long _playerId;
    private String _name;
    private boolean _active;
    private int _score;
    private Date _birthday;
    private String _description;

    public PlayerSoap() {
    }

    public static PlayerSoap toSoapModel(Player model) {
        PlayerSoap soapModel = new PlayerSoap();

        soapModel.setPlayerId(model.getPlayerId());
        soapModel.setName(model.getName());
        soapModel.setActive(model.getActive());
        soapModel.setScore(model.getScore());
        soapModel.setBirthday(model.getBirthday());
        soapModel.setDescription(model.getDescription());

        return soapModel;
    }

    public static PlayerSoap[] toSoapModels(Player[] models) {
        PlayerSoap[] soapModels = new PlayerSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static PlayerSoap[][] toSoapModels(Player[][] models) {
        PlayerSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new PlayerSoap[models.length][models[0].length];
        } else {
            soapModels = new PlayerSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static PlayerSoap[] toSoapModels(List<Player> models) {
        List<PlayerSoap> soapModels = new ArrayList<PlayerSoap>(models.size());

        for (Player model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PlayerSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _playerId;
    }

    public void setPrimaryKey(long pk) {
        setPlayerId(pk);
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
}
