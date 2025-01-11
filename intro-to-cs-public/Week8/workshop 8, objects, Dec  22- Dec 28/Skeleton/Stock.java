public class Stock {
    private String ticker;
    private String companyName;
    private double price;

    public Stock(String ticker, String companyName, double price) {
        // TODO: Initialize the stock with its ticker symbol, company name, and price
    }
    // Why is it ok that the get methods are public?
    public String getTicker() {
        // TODO: Return the stock's ticker symbol
    }

    public String getCompanyName() {
        // TODO: Return the stock's company name
    }

    public double getPrice() {
        // TODO: Return the stock's current price
    }
    // Why is this class private?
    private void setPrice(double newPrice) {
        // TODO: Update the stock's price
    }
    @Override
    public String toString() {
        // TODO: Return a string representation of the stock
    }
}