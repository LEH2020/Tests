package dao;

import entity.MeetingRoom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MeetingRoomDao extends BaseDao {
    //编写查询方法，获取全部会议室使用信息并按使用时间降序排列
    public List<MeetingRoom>  queryMeetingRoom(){
        getConnection();
        List<MeetingRoom> roomList=new ArrayList<>();
        String Sql="select * FROM meetingroom";
        rs=this.executeQuery(Sql);
        try {
            while (rs.next()){
                MeetingRoom room=new MeetingRoom
                        (rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getString(4));
                roomList.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roomList;
    }

    //编写添加方法，添加会议室预定信息
    public int addMeetingRoom(MeetingRoom meetingRoom){
        getConnection();
        String Sql="INSERT INTO meetingroom (meeting_name,meeting_order,advance_name) VALUES(?,?,?)";
        Object []params={meetingRoom.getMeeting_name(),meetingRoom.getMeeting_order(),meetingRoom.getAdvance_name()};
        int result=executeUpdate(Sql,params);
        return result;
    }
}
