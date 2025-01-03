package org.jugistanbul.reward;

public class RewardInformation {
    private long pointsRedeemed;
    private double discount;

    public RewardInformation() { }

    //
    public RewardInformation(long pointsRedeemed, double discount) {
    	setPointsRedeemed(pointsRedeemed);
    	setDiscount(discount);
    }

    public long getPointsRedeemed() {
        return pointsRedeemed;
    }

    public void setPointsRedeemed(long pointsReedemed) {
        this.pointsRedeemed = pointsReedemed;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
