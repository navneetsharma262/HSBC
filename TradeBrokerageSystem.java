package com.nav.myapplication;

import java.util.HashMap;
import java.util.Map;

// Enum for Buy or Sell
enum TradeType {
    BUY,
    SELL
}

// Trade class to represent each trade
class Trade {
    private String tradeId;
    private String shareName;
    private int shareQuantity;
    private double sharePrice;
    private String traderId;
    private TradeType tradeType;

    // Constructor
    public Trade(String tradeId, String shareName, int shareQuantity, double sharePrice, String traderId, TradeType tradeType) {
        this.tradeId = tradeId;
        this.shareName = shareName;
        this.shareQuantity = shareQuantity;
        this.sharePrice = sharePrice;
        this.traderId = traderId;
        this.tradeType = tradeType;
    }

    // Getters
    public String getTradeId() {
        return tradeId;
    }

    public String getShareName() {
        return shareName;
    }

    public int getShareQuantity() {
        return shareQuantity;
    }

    public double getSharePrice() {
        return sharePrice;
    }

    public String getTraderId() {
        return traderId;
    }

    public TradeType getTradeType() {
        return tradeType;
    }
}

// Broker class to handle trade operations
class Broker {
    private Map<String, Trade> tradeMap;

    // Constructor
    public Broker() {
        tradeMap = new HashMap<>();
    }

    // Method to validate and process a trade
    public void processTrade(Trade trade) {
        // Perform validation based on trade type and attributes

        // Example validations:
        // Basic validation of trade details

        if (trade.getTradeType() == TradeType.BUY) {
            // Check wallet balance
            // Block amount in wallet
        } else if (trade.getTradeType() == TradeType.SELL) {
            // Check number of share quantity
            // Block number of share quantity in broker system
        }

        // Process the trade further (e.g., send to Share Exchange, store trade details)
        // For simplicity, we'll just store the trade in a map here
        tradeMap.put(trade.getTradeId(), trade);

        // Report trade status
        // For simplicity, we'll print the trade details here
        System.out.println("Trade processed: " + trade.getTradeId());
    }

    // Method to update an existing trade
    public void updateTrade(String tradeId, Trade updatedTrade) {
        // Perform validation and update logic

        // For simplicity, we'll just update the trade in the map
        tradeMap.put(tradeId, updatedTrade);

        // Report trade status
        // For simplicity, we'll print the updated trade details here
        System.out.println("Trade updated: " + tradeId);
    }

    // Method to cancel an existing trade
    public void cancelTrade(String tradeId) {
        // Perform cancellation logic

        // For simplicity, we'll just remove the trade from the map
        tradeMap.remove(tradeId);

        // Report trade status
        System.out.println("Trade cancelled: " + tradeId);
    }

    // Method to retrieve trade details by tradeId
    public Trade getTradeDetails(String tradeId) {
        // Retrieve trade details from the map
        return tradeMap.get(tradeId);
    }
}

// Main class
public class TradeBrokerageSystem {
    public static void main(String[] args) {
        // Create a Broker object
        Broker broker = new Broker();

        // Example usage:
        // Create a new trade
        Trade newTrade = new Trade("1", "ABC", 100, 10.5, "123", TradeType.BUY);
        // Process the new trade
        broker.processTrade(newTrade);

        // Update an existing trade
        Trade updatedTrade = new Trade("1", "ABC", 100, 10.5, "123", TradeType.SELL);
        broker.updateTrade("1", updatedTrade);

        // Cancel an existing trade
        broker.cancelTrade("1");

        // Retrieve trade details
        Trade retrievedTrade = broker.getTradeDetails("1");
        System.out.println("Retrieved trade: " + retrievedTrade);
    }
}