/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.commsen.liferay.examples.portlet.servicebuilder;

import java.io.IOException;
import java.util.Calendar;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.commsen.liferay.examples.portlet.servicebuilder.service.PlayerLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * <a href="JSPPortlet.java.html"><b><i>View Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class JSPPortlet extends GenericPortlet {

	public void init() throws PortletException {
		viewJSP = getInitParameter("view-jsp");
	}


	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		include(viewJSP, renderRequest, renderResponse);
	}


	@ProcessAction(name = Constants.ADD)
	public void addPlayer(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException, IOException {
		String name = ParamUtil.getString(actionRequest, "name");
		boolean active = ParamUtil.getBoolean(actionRequest, "active");
		int score = ParamUtil.getInteger(actionRequest, "score");
		String description = ParamUtil.getString(actionRequest, "description");
		int year = ParamUtil.getInteger(actionRequest, "birthday_year");
		int month = ParamUtil.getInteger(actionRequest, "birthday_month");
		int day = ParamUtil.getInteger(actionRequest, "birthday_day");

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DAY_OF_MONTH, day);

		try {
			PlayerLocalServiceUtil.addPlayer(name, active, score, calendar.getTime(), description);
		} catch (Exception e) {
			throw new PortletException("Failed to add player", e);
		}
	}


	protected void include(String path, RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		PortletRequestDispatcher portletRequestDispatcher = getPortletContext().getRequestDispatcher(path);

		if (portletRequestDispatcher == null) {
			_log.error(path + " is not a valid include");
		} else {
			portletRequestDispatcher.include(renderRequest, renderResponse);
		}
	}

	protected String viewJSP;

	private static Log _log = LogFactoryUtil.getLog(JSPPortlet.class);

}