package org.holidayReq;

public class SickLeave extends Request {

    protected String reason;

    public SickLeave(String fullName, String employeeNum, String startDate, String endDate, String reason) {
        super(fullName, employeeNum, startDate, endDate);
        this.reason = reason;
    }

     public String requestType() {
         return "Sickness - ";
     }
 }
