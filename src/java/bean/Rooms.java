/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;




public class Rooms {

    String  RoomType,  Status, BookedBy;
    int RoomNo, RoomRent;

    public Rooms() {
        super();
    }

    public Rooms(String RoomType, String Status, String BookedBy, int RoomNo, int RoomRent) {
        this.RoomType = RoomType;
        this.Status = Status;
        this.BookedBy = BookedBy;
        this.RoomNo = RoomNo;
        this.RoomRent = RoomRent;
    }

    public String getRoomType() {
        return RoomType;
    }

    public void setRoomType(String RoomType) {
        this.RoomType = RoomType;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getBookedBy() {
        return BookedBy;
    }

    public void setBookedBy(String BookedBy) {
        this.BookedBy = BookedBy;
    }

    public int getRoomNo() {
        return RoomNo;
    }

    public void setRoomNo(int RoomNo) {
        this.RoomNo = RoomNo;
    }

    public int getRoomRent() {
        return RoomRent;
    }

    public void setRoomRent(int RoomRent) {
        this.RoomRent = RoomRent;
    }
    
    
}
