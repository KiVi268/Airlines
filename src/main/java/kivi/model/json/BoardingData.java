package kivi.model.json;

public class BoardingData {
    private String passengerId;
    private String flightId;
    private String seat;
    private String boardingTime;
    private String departureCity;

    public BoardingData() {}

    public BoardingData(String passengerId, String flightId, String seat,
                        String boardingTime, String departureCity) {
        this.passengerId = passengerId;
        this.flightId = flightId;
        this.seat = seat;
        this.boardingTime = boardingTime;
        this.departureCity = departureCity;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getBoardingTime() {
        return boardingTime;
    }

    public void setBoardingTime(String boardingTime) {
        this.boardingTime = boardingTime;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    @Override
    public String toString() {
        return "BoardingData{" +
                "passengerId='" + passengerId + '\'' +
                ", flightId='" + flightId + '\'' +
                ", seat='" + seat + '\'' +
                ", boardingTime='" + boardingTime + '\'' +
                ", departureCity='" + departureCity + '\'' +
                '}';
    }
}
