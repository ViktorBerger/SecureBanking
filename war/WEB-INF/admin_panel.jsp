<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:main_template title="Admin Panel">
	<jsp:attribute name="body_area">
		<h1>Welcome to admin panel!</h1>
		<div class="col-md-8 col-md-offset-2 main">
					
		<p> This system keeps track of mobile banking transactions. In addition, it also keeps track about
		applications used for this transactions, i.e. application integrity.</p> 
		<p>Application data consists of:</p>
			<ul>
		 <li>smartphone ID</li>
		 <li> message digest of classes.dex file</li>
		 <li>  developers signature</li>
		 </ul>
		
		</div>
	</jsp:attribute>
</t:main_template>