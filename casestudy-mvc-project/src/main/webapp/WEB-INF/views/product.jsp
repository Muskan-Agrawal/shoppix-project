<%@page import="com.muskan.bean.Product"%>
<%@page import="com.muskan.bean.OrderItems"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<spring:form action="selectProducts" method="get" modelAttribute="select">
<h2>Products Available</h2>
            <TABLE>
            <tr>
            	<td>Code</td>
            	<td>Name</td>
            	<td>Description</td>
            	<td>Price</td>
            	<td>Select</td>
            </tr>
            
            <% Collection<Product> productList= (Collection<Product>)request.getAttribute("productList"); %>
            <% for(Product product: productList){%>
                <tr>
                    <td ><%=product.getCode() %></td>
                    <td ><%=product.getName() %></td>
                    <td ><%=product.getDescription() %></td>
                    <td ><%=product.getPrice() %></td>
                    <td ><spring:checkbox path="code" value="<%=product%>"/></td>
                </tr>
                <%} %>
				<td><input type="submit" name="submit" value="submit"></td></tr>
            </TABLE>
        </spring:form>
        <h2>Added products</h2>
        <spring:form action="selectProducts" method="get" modelAttribute="select">
            <TABLE>
            <tr>
            	<td>Product</td>
            	<td>Quantity</td>
            	<td>Price</td>
            </tr>
            
            <% Collection<OrderItems> orders= (Collection<OrderItems>)request.getAttribute("selected");
            if(orders!=null){%> 
            <% for(OrderItems o:orders){%>
                <tr>
                    <td ><%=o.getProductId() %></td>
                    <td ><%=o.getQuantity() %></td>
                    <td ><%=o.getProductPrice() %></td>
                </tr>
                <%} }%>
            </TABLE>
        </spring:form>        
</body>
</html>