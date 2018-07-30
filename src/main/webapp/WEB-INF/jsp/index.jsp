<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

  <head>
    <title>Index</title>
  </head>
    List of products <a href="/create">Create Product</a>

    <table>
      <th>Name</th>
      <th>Description</th>
      <th>Price</th>
      <th>Stock</th>
      <c:forEach items="${products}" var="p">
        <tr>
          <td>${p.getName()}</td>
          <td>${p.getDescription()}</td>
          <td>${p.getPrice()}</td>
          <td>${p.getStock()}</td>
        </tr>
      </c:forEach>
    </table>
