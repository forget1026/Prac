package day4.back.backend.DTO;

public class ElectricityBill {
    private int hour;
    private int consumption;
    private int unitPrice;
    private int cost;

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getConsumption() {
        return consumption;
    }

    public void setConsumption(int consumption) {
        this.consumption = consumption;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "ElectricityBill [consumption=" + consumption + ", cost=" + cost + ", hour=" + hour + ", unitPrice="
                + unitPrice + "]";
    }

}