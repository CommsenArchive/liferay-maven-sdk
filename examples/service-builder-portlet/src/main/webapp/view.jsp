
<%@page import="java.util.List"%>
<%@page import="com.commsen.liferay.examples.portlet.servicebuilder.model.Player"%>
<%@page import="com.commsen.liferay.examples.portlet.servicebuilder.service.PlayerLocalServiceUtil"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="/c" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>


<%@page import="com.liferay.portal.kernel.util.Constants"%>
<portlet:defineObjects />

<% 
request.setAttribute("players",  PlayerLocalServiceUtil.getAllPlayers()); 
%>


<b>Welcome to the Sample Service Builder Portlet!</b>

<br /><br />

<c:if test="${!empty players}">
	<table class="lfr-table">
	<tr>
		<th>
			ID
		</th>
		<th>
			Name
		</th>
		<th>
			Active
		</th>
		<th>
			Score
		</th>
		<th>
			Birthday
		</th>
		<th>
			Description
		</th>
	</tr>

	<c:forEach var="player" items="${players}">

		<tr>
			<td>
				<c:out value="${player.playerId}" />
			</td>
			<td>
				<c:out value="${player.name}" />
			</td>
			<td>
				<c:out value="${player.active}" />
			</td>
			<td>
				<c:out value="${player.score}" />
			</td>
			<td>
				<c:out value="${player.birthday}" />
			</td>
			<td>
				<c:out value="${player.description}" />
			</td>
		</tr>

	</c:forEach>
	
	</table>

	<div class="separator"><!-- --></div>
</c:if>

<portlet:actionURL copyCurrentRenderParameters="true"  portletMode="view" var="portletActionUrl" name="<%= Constants.ADD %>"/>

<form action="<c:out value="${portletActionUrl}" />" method="post" name="<portlet:namespace />fm" onSubmit="submitForm(document.<portlet:namespace />fm); return false;">

<table class="lfr-table">
<tr>
	<td>
		Name
	</td>
	<td>
		<liferay-ui:input-field model="<%= Player.class %>" field="name" />
	</td>
</tr>
<tr>
	<td>
		Active
	</td>
	<td>
		<liferay-ui:input-field model="<%= Player.class %>" field="active" />
	</td>
</tr>
<tr>
	<td>
		Score
	</td>
	<td>
		<liferay-ui:input-field model="<%= Player.class %>" field="score" />
	</td>
</tr>
<tr>
	<td>
		Birthday
	</td>
	<td>
		<liferay-ui:input-date yearRangeEnd="2009" yearRangeStart="1900" dayParam="birthday_day" monthParam="birthday_month" yearParam="birthday_year"/>
	
	</td>
</tr>
<tr>
	<td>
		Description
	</td>
	<td>
		<liferay-ui:input-field model="<%= Player.class %>" field="description" />
	</td>
</tr>
</table>

<br />

<input type="submit" value="<liferay-ui:message key="add" />" />

</form>