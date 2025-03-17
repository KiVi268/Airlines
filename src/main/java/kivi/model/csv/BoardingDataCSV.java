package kivi.model.csv;

import java.util.Date;

public class BoardingDataCSV {
    private String passengerFirstName;
    private String passengerSecondName;
    private String passengerLastName;
    private String passengerSex;
    private String passengerBirthDate;
    private String passengerDocument;
    private String bookingCode;
    private String ticketNumber;
    private String baggage;
    private String flightDate;
    private String flightTime;
    private String flightNumber;
    private String codeShare;
    private String destination;

    public BoardingDataCSV() {
    }

    public BoardingDataCSV(String passengerFirstName, String passengerSecondName, String passengerLastName, String passengerSex, String passengerBirthDate, String passengerDocument, String bookingCode, String ticketNumber, String baggage, String flightDate, String flightTime, String flightNumber, String codeShare, String destination) {
        this.passengerFirstName = passengerFirstName;
        this.passengerSecondName = passengerSecondName;
        this.passengerLastName = passengerLastName;
        this.passengerSex = passengerSex;
        this.passengerBirthDate = passengerBirthDate;
        this.passengerDocument = passengerDocument;
        this.bookingCode = bookingCode;
        this.ticketNumber = ticketNumber;
        this.baggage = baggage;
        this.flightDate = flightDate;
        this.flightTime = flightTime;
        this.flightNumber = flightNumber;
        this.codeShare = codeShare;
        this.destination = destination;
    }

    public String getPassengerFirstName() {
        return passengerFirstName;
    }

    public void setPassengerFirstName(String passengerFirstName) {
        this.passengerFirstName = passengerFirstName;
    }

    public String getPassengerSecondName() {
        return passengerSecondName;
    }

    public void setPassengerSecondName(String passengerSecondName) {
        this.passengerSecondName = passengerSecondName;
    }

    public String getPassengerLastName() {
        return passengerLastName;
    }

    public void setPassengerLastName(String passengerLastName) {
        this.passengerLastName = passengerLastName;
    }

    public String getPassengerSex() {
        return passengerSex;
    }

    public void setPassengerSex(String passengerSex) {
        this.passengerSex = passengerSex;
    }

    public String getPassengerBirthDate() {
        return passengerBirthDate;
    }

    public void setPassengerBirthDate(String passengerBirthDate) {
        this.passengerBirthDate = passengerBirthDate;
    }

    public String getPassengerDocument() {
        return passengerDocument;
    }

    public void setPassengerDocument(String passengerDocument) {
        this.passengerDocument = passengerDocument;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getBaggage() {
        return baggage;
    }

    public void setBaggage(String baggage) {
        this.baggage = baggage;
    }

    public String getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    public String getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(String flightTime) {
        this.flightTime = flightTime;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getCodeShare() {
        return codeShare;
    }

    public void setCodeShare(String codeShare) {
        this.codeShare = codeShare;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "BoardingData{" +
                "passengerFirstName='" + passengerFirstName + '\'' +
                ", passengerSecondName='" + passengerSecondName + '\'' +
                ", passengerLastName='" + passengerLastName + '\'' +
                ", passengerSex='" + passengerSex + '\'' +
                ", passengerBirthDate='" + passengerBirthDate + '\'' +
                ", passengerDocument='" + passengerDocument + '\'' +
                ", bookingCode='" + bookingCode + '\'' +
                ", ticketNumber='" + ticketNumber + '\'' +
                ", baggage='" + baggage + '\'' +
                ", flightDate='" + flightDate + '\'' +
                ", flightTime='" + flightTime + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                ", codeShare='" + codeShare + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }
}
