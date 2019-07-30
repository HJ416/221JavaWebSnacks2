<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
   function toOpenDetailWindow(_id){
	    var url="../snacksDetailServlet?id="+_id+"&"+Math.random();
	    window.open
   }
</script>

<c:forEach items="${foodList }" var="food">
	<li>
		<div class="i-pic limit" onclick="toOpenDetailWindow(${food.fdId})">
			<img src="../${food.listPicUrl }" />
			<p class="title fl">${food.fdName }</p>
			<p class="price fl">
				<b>¥</b> <strong>${food.fdPrice }</strong>
			</p>
			<p class="number fl">
				销量<span>${food.salesCount }</span>
			</p>
		</div>
	</li>
	<li>
</c:forEach>
