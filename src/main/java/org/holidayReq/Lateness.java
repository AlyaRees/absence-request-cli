package org.holidayReq;

public class Lateness extends Request {

    protected float hoursLate;

    public Lateness(String fullName, String employeeNum, String startDate, String endDate, float hoursLate) {
        super(fullName, employeeNum, startDate, endDate);
        this.hoursLate = hoursLate;
    }

    public String requestType() {
        return "Lateness - ";
    }
}
