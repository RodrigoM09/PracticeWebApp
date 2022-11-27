        <%@include file="common/header.jspf"%>
        <%@include file="common/navigation.jspf"%>
        <%--CONTAINER WITH TODOS TABLE--------------------------------------------------------%>
        <div class="container">
            <div>Welcome, ${name}!</div><br>
            <hr>
            <h1>Your todos:</h1>
            <table class="table">
                <thead>
                    <tr>
                        <th>Description</th>
                        <th>Target Date</th>
                        <th>Is Done?</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${todos}" var="todo">
                        <tr>
                            <td>${todo.description}</td>
                            <td>${todo.targetDate}</td>
                            <td>${todo.done}</td>
                            <td><a href="update-todo?id=${todo.id}" class="btn btn-success">Update</a></td>
                            <td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">DELETE</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="add-todo" class="btn btn-success">Add Todo</a>
        </div>
        <%--END OF TODOS CONTAINER---------------------------------------------------------------------%>
        <%@ include file="common/footer.jspf"%>