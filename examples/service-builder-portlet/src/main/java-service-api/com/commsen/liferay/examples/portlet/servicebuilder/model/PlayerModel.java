package com.commsen.liferay.examples.portlet.servicebuilder.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="PlayerModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>Player</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.commsen.liferay.examples.portlet.servicebuilder.model.Player
 * @see com.commsen.liferay.examples.portlet.servicebuilder.model.impl.PlayerImpl
 * @see com.commsen.liferay.examples.portlet.servicebuilder.model.impl.PlayerModelImpl
 *
 */
public interface PlayerModel extends BaseModel<Player> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getPlayerId();

    public void setPlayerId(long playerId);

    public String getName();

    public void setName(String name);

    public boolean getActive();

    public boolean isActive();

    public void setActive(boolean active);

    public int getScore();

    public void setScore(int score);

    public Date getBirthday();

    public void setBirthday(Date birthday);

    public String getDescription();

    public void setDescription(String description);

    public Player toEscapedModel();
}
