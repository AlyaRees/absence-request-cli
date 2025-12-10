package org.holidayReq;

public class Holiday extends Request {

    public Holiday(String fullName, String employeeNum, String startDate, String endDate) {
        super(fullName, employeeNum, startDate, endDate);
    }

    public String requestType() {
        return "Holiday - ";
    }
}
