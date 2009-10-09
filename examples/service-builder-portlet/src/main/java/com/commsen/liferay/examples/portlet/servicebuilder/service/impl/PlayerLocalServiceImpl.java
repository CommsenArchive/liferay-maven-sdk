package com.commsen.liferay.examples.portlet.servicebuilder.service.impl;

import java.util.Date;
import java.util.List;

import com.commsen.liferay.examples.portlet.servicebuilder.model.Player;
import com.commsen.liferay.examples.portlet.servicebuilder.service.base.PlayerLocalServiceBaseImpl;
import com.commsen.liferay.examples.portlet.servicebuilder.service.persistence.PlayerUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;

public class PlayerLocalServiceImpl extends PlayerLocalServiceBaseImpl {

	public void addPlayer(String name, boolean active, int score, Date birthday, String desc) throws PortalException, SystemException {

		long fooId = CounterLocalServiceUtil.increment();

		Player player = PlayerUtil.create(fooId);

		player.setName(name);
		player.setActive(active);
		player.setScore(score);
		player.setBirthday(birthday);
		player.setDescription(desc);

		PlayerUtil.update(player, false);
	}


	public List<Player> getAllPlayers() throws PortalException, SystemException {
		return PlayerUtil.findAll();
	}

}
