<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251"%>
<%@ page session="false" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<html>
<head>
    <title>Разработчики</title>
    <!-- Bootstrap core CSS -->
    <!-- Bootstrap Core CSS -->
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<!--script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.9.1/jquery.min.js"/-->
<!--script src="/WEB-INF/pages/bootstrap-3.3.5-dist/js/bootstrap.min.js"/-->

<a href="../../index.jsp">Назад в меню</a>

<br/>
<br/>

<h2>Разработчики</h2>

<input type="search" name="search" placeholder="Search"/>
<input type="submit" value="Search">

<c:if test="${!empty listDevelopers}">

    <table class="table table-striped" background-color: #f9f9f9>
        <tr>
            <th width="80" class="warning">ID</th>
            <th width="120" class="danger">Имя</th>
            <th width="120" class="danger">Проекты</th>
            <th width="120">Навыки</th>
            <th width="120">Зарплата</th>
            <th width="120">Стаж</th>
            <th width="60">Изменить</th>
            <th width="60">Удалить</th>
        </tr>

        <c:forEach items="${listDevelopers}" var="developer">
            <tr>
                <td>${developer.id}</td>
                <td>${developer.name}</td>
                <td>${developer.projects}</td>
                <td>${developer.skill}</td>
                <td>${developer.salary}</td>
                <td>${developer.experience}</td>
                <td><a href="<c:url value='/editDeveloper/${developer.id}' />">Edit</a></td>
                <td><a href="<c:url value='/removeDeveloper/${developer.id}' />">Delete</a></td>
            </tr>
        </c:forEach>
</table>
</c:if>

<h1>Добавить разработчика</h1>

<c:url var="addAction" value="/developers/add"/>

<form:form action="${addAction}" commandName="developer">
<table class="table">
        <c:if test="${!empty developer.name}">
            <table class="table table-striped">
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
                           value="<spring:message text="Изменить данные"/>"/>
                </c:if>
                <c:if test="${empty developer.name}">
                    <input type="submit"
                           value="<spring:message text="Добавить"/>"/>
                </c:if>
            </td>
        </tr>
</table>
</form:form>
<script src="/WEB-INF/pages/js/bootstrap.min.js"></script>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
            <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>