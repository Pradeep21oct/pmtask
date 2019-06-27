package com.cts.pmapps.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
@Entity
@Table(name="PROJECT")
public class Project {
    @Column(name = "START_DATE")
    private Date startDate;
    @Column(name = "END_DATE")
    public Date endDate;
    @Column(name = "PRIORITY")
    public Integer priority;

    @Column(name = "NO_OF_TASK")
    public Integer noOfTask;
    @Id
    @Column(name = "PROJECT_ID",insertable=false, updatable=false)
    @GeneratedValue
    public Integer projectId;
    @Column(name = "PROJECT_NAME")
    public String projectName;
    @Column(name = "PROJECT_MANAGER")
    public String projectManager;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "PROJECT_STATUS")
    public String status;

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

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getNoOfTask() {
        return noOfTask;
    }

    public void setNoOfTask(Integer noOfTask) {
        this.noOfTask = noOfTask;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(startDate, project.startDate) &&
                Objects.equals(endDate, project.endDate) &&
                Objects.equals(priority, project.priority) &&
                Objects.equals(noOfTask, project.noOfTask) &&
                Objects.equals(projectId, project.projectId) &&
                Objects.equals(projectName, project.projectName) &&
                Objects.equals(projectManager, project.projectManager) &&
                Objects.equals(status, project.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate, priority, noOfTask, projectId, projectName, projectManager, status);
    }
}
