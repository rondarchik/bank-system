package com.victoria.app.core.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "action_logs")
public class ActionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "log_text")
    private String logText;

    @Column(name = "date")
    private Date date;

    public ActionLog() {
    }

    public ActionLog(String logText, Date date) {
        this.logText = logText;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogText() {
        return logText;
    }

    public void setLogText(String logText) {
        this.logText = logText;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
