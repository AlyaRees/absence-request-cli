package org.holidayReq;

// This class defines the blueprint for different shapes of absence requests. It is abstract as it should not be instantiated.
public abstract class Absence {
    private String fullName;
    private String employeeNum;

    public Absence(String fullName, String employeeNum) {
        this.fullName = fullName;
        this.employeeNum = employeeNum;
    }

    // these methods are abstract as they must be features of subclasses and must be in this specific shape (must return strings).
    public abstract String requestType();

    public abstract String getAdditionalInfo();

    // A common feature. All types of absence requests must return a string containing all details to be written to the file when they are saved.
    public String details() {
        return "Request: " + requestType() + "Name: " + this.fullName + " Employee Number: " + this.employeeNum + " Date: " + getAdditionalInfo() + " - PENDING APPROVAL\n";
    }
}