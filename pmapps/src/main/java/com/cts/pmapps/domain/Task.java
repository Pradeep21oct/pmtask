package com.cts.pmapps.domain;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="task")
public class Task {
    @Column(name = "START_DATE")
    public Date startDate;
    @Column(name = "END_DATE")
    public Date endDate;
    @Column(name = "PRIORITY")
    public int priority;
    @Column(name = "STATUS")
    public String status;
    @Id
    @Column(name = "TASK_ID",insertable=false, updatable=false)
    @GeneratedValue
    public int taskId;
    @Column(name = "TASK_NAME")
    public String taskName;
    @Column(name = "PARENT_ID")
    public String parent;
    @Column(name = "PROJECT_ID")
    public String project;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }
}
