public class Portfolio {
    private Stock[] stocks;
    private int[] quantities;
    private int count;

    public Portfolio(int maxSize) {
        this.stocks = new Stock[maxSize];
        this.quantities = new int[maxSize];
        this.count = 0;
    }

    public void addStock(Stock stock, int quantity) {
        for (int i = 0; i < count; i++) {
            if (stocks[i].getTicker().equals(stock.getTicker())) {
                quantities[i] += quantity;
                return;
            }
        }

        if (count < stocks.length) {
            stocks[count] = stock;
            quantities[count] = quantity;
            count++;
        } else {
            System.out.println("Portfolio is full. Cannot add more stocks.");
        }
    }

    public void displayPortfolio() {
        System.out.println("Your Portfolio:");
        for (int i = 0; i < count; i++) {
            System.out.println(stocks[i] + " - Quantity: " + quantities[i]);
        }
    }

    public double calculateTotalValue() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += stocks[i].getPrice() * quantities[i];
        }
        return total;
    }
    
    private int findStockIndex(String ticker) {
        for (int i = 0; i < count; i++) {
            if (stocks[i].getTicker().equals(ticker)) {
                return i;
            }
        }
        return -1;
    }
}