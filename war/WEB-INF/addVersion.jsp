<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:main_template title="Transactions">

	<jsp:attribute name="body_area">

		<div class="col-md-6 col-md-offset-3">
			<legend>Add new version</legend>
			<form method="POST" action="/versions">
				  <div class="form-group">
				    <label for="version">Version</label>
				    <input type="text" class="form-control" name="version"
										placeholder="version id" required>
				  </div>
				  <div class="form-group">
				    <label for="hash">Hash</label>
				    <input type="text" class="form-control" name="hash"
										placeholder="hash" required>
				  </div>
				  <div class="form-group">
				    <label for="signature">Signature</label>
				    <input type="text" class="form-control" name="signature"
										placeholder="signature" required>
				  </div>
				
				
				  <button type="submit" class="btn btn-default">Add</button>
				</form>
		</div>

	</jsp:attribute>

</t:main_template>



