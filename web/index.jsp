<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="entity.MeetingRoom" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/16 0016
  Time: 上午 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link type="text/css" rel="styleSheet"  href="css/css.css" />
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <%
         List<MeetingRoom> lists=(List<MeetingRoom>)request.getAttribute("list");
         if(lists==null)
         {
          response.sendRedirect("MeetingRoomServlet?opr=select");
          return;
          }
    %>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <table border="2px" style="border: 1px solid black;text-align: center;margin:0px auto">
    <tr style="background:darkgrey "><td>编号</td><td>会议室名称</td><td>预定人</td><td>时间</td></tr>
    <c:forEach items="${list}" var="temp" varStatus="status">
      <tr <c:if test="${status.index%2==1}">style="background: #a98c24;" </c:if>>
        <td>${temp.id}</td>
        <td>${temp.meeting_name}</td>
        <td>${temp.meeting_order}</td>
        <td>${temp.advance_name}</td>
      </tr>
    </c:forEach>
  </table>
  <a style="left: 770px; position: relative"  id="btn1" name="btn1"  onclick="javascript:location.href='MeetingRoomAdd.jsp';"><span colour="#9932CD ">添加关键字</span></a>

  </body>
</html>
