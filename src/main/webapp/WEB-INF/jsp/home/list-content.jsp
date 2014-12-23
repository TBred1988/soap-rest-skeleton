<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<ul>
    <h3>Size: ${fn:length(users)}</h3>
    <c:forEach items="${users}" var="user">
        <li><span>${user.firstName}</span><br />
            <span>${user.lastName}</span><br />
            <span>${user.email}</span><br />
            <span>${user.password}</span><br />
        </li>
    </c:forEach>
</ul>
