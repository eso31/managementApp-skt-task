<%@ page import="com.skytask.model.Product" %>
<%@ page import="java.util.List" %>

<%
List<Product> products = (List<Product>) request.getAttribute("products");
%>

<table>

<tr>
<td>Name</td>
<td>Description</td>
<td>Price</td>
<td>Stock</td>
</tr>

<% for(Product p : products){ %>
<tr>
<td><%= p.getName() %> </td>
<td><%= p.getDescription() %></td>
<td><%= p.getPrice() %></td>
<td><%= p.getStock() %></td>

</tr>

<% } %>

</table>