<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:main_template title="Footprints">

	<jsp:attribute name="body_area">
	<legend><h1>Footprints</h1></legend>
	<div id="mainTable">
		<table class="table table-striped">
		<thead>
			<tr>
				<th>#</th>
				<th>DeviceID</th>
				<th>Hash</th>
				<th>Signature</th>
				<th>Timestamp</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${footprints}" var="foot" varStatus="rowNumber">
				
				
			   <c:if test="${foot.valid == false}">
			  	<c:set value="danger" var="cssClass"></c:set>
			   </c:if>
						
			   <c:if test="${foot.valid == true}">
			  	<c:set value="success" var="cssClass"></c:set>
			   </c:if>
				
				
				<tr class="${cssClass}">
					<td><c:out value="${rowNumber.count}" /></td>
					<td><c:out value="${foot.deviceID}" /></td>
					<td><c:out value="${foot.hash}" /></td>
					<td><c:out value="${foot.signature}" /></td>
					<td><fmt:formatDate value="${foot.timestamp}"
								pattern="dd.MM.yyyy HH:mm:ss" /></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>

</jsp:attribute>
</t:main_template>
