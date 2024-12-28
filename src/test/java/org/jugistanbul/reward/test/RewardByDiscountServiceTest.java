package org.jugistanbul.reward.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Collections;
import java.util.List;

import org.jugistanbul.product.Product;
import org.jugistanbul.reward.RewardByDiscountService;
import org.jugistanbul.reward.RewardInformation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RewardByDiscountServiceTest {
    private RewardByDiscountService reward = null;

    @BeforeEach
    void setUp() {
        reward = new RewardByDiscountService();
        reward.setPercentage(0.1);
        reward.setNeededPoints(100);
    }

    @Test
    @DisplayName("When customer has zero points no reward should be applied")
    void zeroCustomerPoints() {
        Product smallDecaf = new Product(1, "Small Decaf", 1.99);
        List<Product> order = Collections.singletonList(smallDecaf);

        RewardInformation info = reward.applyReward(order, 0);

        System.out.println("hello africa");

        assertEquals(0, info.getDiscount());
        assertEquals(0, info.getPointsRedeemed());
    }

    @Test
    @DisplayName("When customer has enough points reward should be applied")
    void customerHasEnoughPoints() {
        Product smallDecaf = new Product(1, "Small Decaf", 1.99);
        List<Product> order = Collections.singletonList(smallDecaf);

        RewardInformation info = reward.applyReward(order, 100);

        System.out.println("hello africa");

        assertEquals(0.199, info.getDiscount());
        assertEquals(reward.getPointsRedeem(), info.getPointsRedeemed());
    }
}