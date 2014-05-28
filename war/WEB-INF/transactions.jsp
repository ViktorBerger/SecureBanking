<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:main_template title="Transactions">

	<jsp:attribute name="body_area">

<legend><h1>Transactions</h1></legend>
	<div id="transactionsTable">
		<table class="table table-striped">
		<thead>
			<tr>
				<th>#</th>
				<th>Sender</th>
				<th>Recipient</th>
				<th>Amount</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${transactions}" var="transaction"
					varStatus="rowNumber">
				<tr>
					<td><c:out value="${rowNumber.count}" /></td>
					<td><c:out value="${transaction.senderAccount}" /></td>
					<td><c:out value="${transaction.recipientAccount}" /></td>
					<td><c:out value="${transaction.amount}" /></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>

</jsp:attribute>

</t:main_template>



