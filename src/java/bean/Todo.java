/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;



public class Todo {
    int id; 
    String Actions, Date, Time;

    public Todo() {
        super();
    }

    public Todo(int id, String Actions, String Date, String Time) {
        this.id = id;
        this.Actions = Actions;
        this.Date = Date;
        this.Time = Time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActions() {
        return Actions;
    }

    public void setActions(String Actions) {
        this.Actions = Actions;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }
    
    
    
}
