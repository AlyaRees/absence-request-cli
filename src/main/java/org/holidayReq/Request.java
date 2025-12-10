package org.holidayReq;

public abstract class Request {
    private String fullName;
    private String employeeNum;
    private String startDate;
    private String endDate;

    public Request(String fullName, String employeeNum, String startDate, String endDate) {
        this.fullName = fullName;
        this.employeeNum = employeeNum;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public abstract String requestType();

    public String fileContents() {
        return "Request: " + requestType() + "Name: " + this.fullName + " Employee Number: " + this.employeeNum + " Date: " + this.startDate + " " + this.endDate + " - PENDING APPROVAL\n";
    }
}

// sick leave

// lateness for work

// holiday

