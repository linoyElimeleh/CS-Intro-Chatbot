public class Stock {
    private String ticker;
    private String companyName;
    private double price;

    public Stock(String ticker, String companyName, double price) {
        this.ticker = ticker;
        this.companyName = companyName;
        this.price = price;
    }

    public String getTicker() {
        return ticker;
    }

    public String getCompanyName() {
        return companyName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
    }

    public String toString() {
        return ticker + " (" + companyName + "): $" + price;
    }
}