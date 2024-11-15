package org.jugistanbul.reward;

import org.jugistanbul.product.Product;

import java.util.List;

public abstract class RewardService {
    protected long neededPoints;

    public abstract RewardInformation applyReward(
            List<Product> order, long customerPoints);

    protected double calculateTotal(List<Product> order) {
        double sum = 0;

        if(order != null) {
            sum = order.stream().mapToDouble(Product::getPrice).sum();
        }

        return sum;
    }

    public long getPointsRedeem() {
        return neededPoints;
    }

    public void setNeededPoints(long neededPoints) {
        this.neededPoints = neededPoints;
    }
}
