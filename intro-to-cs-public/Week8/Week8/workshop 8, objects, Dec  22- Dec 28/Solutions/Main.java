public class Main {
    public static void main(String[] args) {
        // Create stock instances
        Stock apple = new Stock("AAPL", "Apple Inc.", 150.50);
        Stock google = new Stock("GOOGL", "Alphabet Inc.", 2800.00);

        // Create a portfolio instance
        Portfolio portfolio = new Portfolio(5);

        // Add stocks to the portfolio
        portfolio.addStock(apple, 10);
        portfolio.addStock(google, 5);

        // Display the portfolio
        portfolio.displayPortfolio();

        // Calculate and print the total value of the portfolio
        System.out.println("Total Portfolio Value: $" + portfolio.calculateTotalValue());

        // Update stock prices and observe changes
        apple.setPrice(155.00);
        System.out.println("\nAfter updating Apple's stock price:");
        portfolio.displayPortfolio();
        System.out.println("Total Portfolio Value: $" + portfolio.calculateTotalValue());
    }
}