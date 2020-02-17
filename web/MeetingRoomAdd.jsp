<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/16 0016
  Time: 下午 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script>
    $(function () {
        $("#form1").submit(check);
        $("#meeting_name").blur(checkUser);
    });
    function checkUser() {
        var $name=$("#meeting_name");
        var $span=$("#span1");
        $span.html("");
        if($name.val()==""){
            $span.html("会议室不能为空！");
        }
    }
    function check() {
        var $name=$("#meeting_name");
        var $type=$("#advance_name");
        var $date=$("#meeting_order");
        var reg=/^\d{4}-\d{1,2}-\d{1,2}$/
        if($name.val()==""||$type.val()==""||$date.val()==""){
            alert("请填写完整的预定信息！");
            return false;
        }else if(!reg.test($date.val())){
            alert("日期格式不正确！");
            return false;
        }
        return true;
    }
</script>
<body>
<form action="MeetingRoomServlet?opr=insert" id="form1" method="post">
    <table style="border:1px solid black;text-align: center;margin:0px auto ">
        <tr>
            <td colspan="2" class="bg"><h2>会议室预定</h2></td>
        </tr>
        <tr>
            <td  class="bg">会议室：</td>
            <td>
                <select type="text" id="meeting_name" name="meeting_name">
                    <option value ="一号会议室">一号会议室</option>
                    <option value ="二号会议室">二号会议室</option>
                    <option value="三号会议室">三号会议室</option>
                    <option value="四号会议室">四号会议室</option>
                </select></td>
        </tr>
        <tr>
            <td  class="bg">申请人：</td>
            <td><input type="text" id="advance_name" name="advance_name"/></td>
        </tr>
        <tr>
            <td  class="bg">预定时间：</td>
            <td><input type="text" id="meeting_order" name="meeting_order"/></td>
        </tr>
        <tr>
            <td><input type="submit" name="sub1" value="申请"></td>
            <td ><input type="reset" name="res1" value="重置"></td>
        </tr>
    </table>
</form>
</body>
</html>
