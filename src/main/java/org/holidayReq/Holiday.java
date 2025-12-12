package org.holidayReq;

public class Holiday extends Absence {

    protected String startDate;
    protected String endDate;

    public Holiday(String fullName, String employeeNum, String startDate, String endDate) {
        super(fullName, employeeNum);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // specifies type of request to be written to the file.
    public String requestType() {
        return "Holiday - ";
    }

    // adds additional information that might not be required of other types of absence requests
    public String getAdditionalInfo() {
        return this.startDate + " " + this.endDate;
    }
}
