<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>

<html>
<head>
    <title>Projects Page</title>

    <style type="text/css">

        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>

<a href="../../index.jsp">Back to main menu</a>

<br/>
<br/>

<h1>Projects List</h1>

<input type="search" name="search" placeholder="Search"/>
<input type="submit" value="Search">
<br/>
<br/>


<c:if test="${!empty listProjects}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Name</th>
            <th width="120">Developers</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
            <th width="120">Add developers</th>

        </tr>
        <c:forEach items="${listProjects}" var="project">
            <tr>
                <td>${project.id}</td>
                <td><a href="<c:url value='/projectdata/${project.id}' />" target="_blank">${project.name}</a></td>
                <td>${project.id}</td>
                <td><a href="<c:url value='/edit/${project.id}' />">Edit</a></td>
                <td><a href="<c:url value='/remove/${project.id}' />">Delete</a></td>
                <td><a href="<c:url value='/add/${project.id}' />">Add developers</a></td>

            </tr>
        </c:forEach>
    </table>
</c:if>

<h1>Add a Project</h1>

<c:url var="addAction" value="/projects/add"/>

<form:form action="${addAction}" commandName="project">
    <table>
        <c:if test="${!empty project.name}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>


        <tr>
            <td colspan="2">
                <c:if test="${!empty project.name}">
                    <input type="submit"
                           value="<spring:message text="Edit Project"/>"/>
                </c:if>
                <c:if test="${empty project.name}">
                    <input type="submit"
                           value="<spring:message text="Add Project"/>"/>
                </c:if>
                <c:if test="${empty project.name}">
                    <input type="submit"
                           value="<spring:message text="Add developers"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>
