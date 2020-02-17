package entity;

import java.util.Date;

public class MeetingRoom {
    private int id;//编号
    private String meeting_name;//会议室名称
    private Date meeting_order;//预定日期
    private String advance_name;//预定人

    //无参构造
    public MeetingRoom() {

    }
        //有参构造
    public MeetingRoom(String meeting_name, Date meeting_order, String advance_name) {
        this.meeting_name = meeting_name;
        this.meeting_order = meeting_order;
        this.advance_name = advance_name;
    }

    //有参构造
    public MeetingRoom(int id, String meeting_name, Date meeting_order, String advance_name) {
        this.id = id;
        this.meeting_name = meeting_name;
        this.meeting_order = meeting_order;
        this.advance_name = advance_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMeeting_name() {
        return meeting_name;
    }

    public void setMeeting_name(String meeting_name) {
        this.meeting_name = meeting_name;
    }

    public Date getMeeting_order() {
        return meeting_order;
    }

    public void setMeeting_order(Date meeting_order) {
        this.meeting_order = meeting_order;
    }

    public String getAdvance_name() {
        return advance_name;
    }

    public void setAdvance_name(String advance_name) {
        this.advance_name = advance_name;
    }
}
