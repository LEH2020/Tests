package servlet;

import dao.MeetingRoomDao;
import entity.MeetingRoom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "MeetingRoomServlet",urlPatterns = "/MeetingRoomServlet")
public class MeetingRoomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MeetingRoomDao room =new MeetingRoomDao();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        HttpSession session=request.getSession();
        String opr=request.getParameter("opr");
        if("select".equals(opr)){
            List<MeetingRoom> lists=room.queryMeetingRoom();
            request.setAttribute("list", lists);
            request.getRequestDispatcher("index.jsp")
                    .forward(request,response);

        }else if("insert".equals(opr)) {
            String meeting_name = request.getParameter("meeting_name");
            String advance_name = request.getParameter("advance_name");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
            try {
                date = sdf.parse(request.getParameter("meeting_order"));

            } catch (Exception ex) {
                ex.printStackTrace();
            }
            MeetingRoom meetingRoom = new MeetingRoom(meeting_name, date, advance_name);
            int result = room.addMeetingRoom(meetingRoom);
            if (result > 0) {
                out.print("<script>alert('插入成功');location='index.jsp'</script>");
            } else {
                out.print("<script>alert('插入失败');location='add.jsp'</script>");
            }
        }
    }
}

