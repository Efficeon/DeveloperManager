<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>

<html>
<head>
    <title>Developers Page</title>

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

<h1>Developers List</h1>

<input type="search" name="search" placeholder="Search"/>
<input type="submit" value="Search">
<br/>
<br/>

<c:if test="${!empty listDevelopers}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Name</th>
            <th width="120">Skill</th>
            <th width="120">Salary</th>
            <th width="120">Experience</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>

        </tr>
        <c:forEach items="${listDevelopers}" var="developer">
            <tr>
                <td>${developer.id}</td>
                <td><a href="<c:url value='/developerdata/${developer.id}' />" target="_blank">${developer.name}</a></td>
                <td>${developer.name}</td>
                <td>${developer.skill}</td>
                <td>${developer.salary}</td>
                <td>${developer.experience}</td>
                <td><a href="<c:url value='/edit/${developer.id}' />">Edit</a></td>
                <td><a href="<c:url value='/remove/${developer.id}' />">Delete</a></td>

            </tr>
        </c:forEach>
    </table>
</c:if>

<h1>Add a Developer</h1>

<c:url var="addAction" value="/developers/add"/>

<form:form action="${addAction}" commandName="developer">
    <table>
        <c:if test="${!empty developer.name}">
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
            <td>
                <form:label path="skill">
                    <spring:message text="Skill"/>
                </form:label>
            </td>
            <td>
                <form:input path="skill"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="salary">
                    <spring:message text="Salary"/>
                </form:label>
            </td>
            <td>
                <form:input path="salary"/>
            </td>
        </tr>

        <tr>
            <td colspan="2">
                <c:if test="${!empty developer.name}">
                    <input type="submit"
                           value="<spring:message text="Edit Developer"/>"/>
                </c:if>
                <c:if test="${empty developer.name}">
                    <input type="submit"
                           value="<spring:message text="Add Developer"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>