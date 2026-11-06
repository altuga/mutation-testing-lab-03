        package org.jugistanbul.reward;

import org.jugistanbul.product.Product;

import java.util.List;

/**
 * RewardByDiscountService is a concrete implementation of RewardService that applies a discount to the order total based on the customer's points.
 * It calculates the discount as a percentage of the order total
 * And returns the reward information.
 */
public class RewardByDiscountService extends RewardService {
    private double percentage;

    @Override
    public RewardInformation applyReward(
            List<Product> order, long customerPoints) {
        RewardInformation rewardInformation = new RewardInformation();

        if(customerPoints >= neededPoints) {
            // if customer has enough points then apply discount
            double orderTotal = calculateTotal(order);
            double discount = orderTotal * getPercentage();
            rewardInformation = new RewardInformation(getPointsRedeem(), discount);
        }

        return rewardInformation;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        if(percentage > 0) {
            this.percentage = percentage;
        } else {
            throw new IllegalArgumentException("Percentage should be greater than zero");
        }
    }
}