<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:main_template title="Versions">

	<jsp:attribute name="body_area">


	<div id="versionsTable" class="col-md-8 col-md-offset-2">
		<legend><h1>Versions</h1></legend>
		<table class="table table-striped">
		<thead>
			<tr>
				<th>#</th>
				<th>Version</th>
				<th>Hash</th>
				<th>Signature</th>
				<th></th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${versions}" var="version"
					varStatus="rowNumber">
				<tr>
					<td><c:out value="${rowNumber.count}" /></td>
					<td><c:out value="${version.version}" /></td>
					<td><c:out value="${version.hash}" /></td>
					<td><c:out value="${version.signature}" /></td>
					<td><a href="/versions/remove?id=<c:out value="${version.id}"/>"><span class="glyphicon glyphicon-remove"></span></a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<a class="btn btn-primary" href="/versions/add">Add new Version</a>
	</div>
	
	

</jsp:attribute>

</t:main_template>



