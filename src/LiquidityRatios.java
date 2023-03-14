public class LiquidityRatios {
    public static final String[] requiredParams = {
            Constants.OPERATING_CASH_FLOW,
            Constants.CASH_AND_CASH_EQUIVALENTS,
            Constants.CURRENT_ASSETS,
            Constants.INVENTORIES,
            Constants.CURRENT_LIABILITIES
    };
    private final double operatingCashFlow;
    private final double cashAndCashEquivalents;
    private final double currentAssets;
    private final double inventories;
    private final double currentLiabilities;

    public LiquidityRatios(double operatingCashFlow, double cashAndCashEquivalents, double currentAssets,
                           double inventories, double currentLiabilities) throws IllegalArgumentException {
        if (operatingCashFlow <= 0 || cashAndCashEquivalents <= 0 || currentAssets <= 0 || inventories <= 0 || currentLiabilities <= 0) {
            throw new IllegalArgumentException("Input parameters must be greater than zero.");
        }
        this.operatingCashFlow = operatingCashFlow;
        this.cashAndCashEquivalents = cashAndCashEquivalents;
        this.currentAssets = currentAssets;
        this.inventories = inventories;
        this.currentLiabilities = currentLiabilities;
    }

    public double getOperatingCashFlowRatio() throws IllegalArgumentException {
        if (currentLiabilities == 0) {
            throw new IllegalArgumentException("Current liabilities cannot be zero.");
        }
        double operatingCashFlowRatio = operatingCashFlow / currentLiabilities;
        if (Double.isInfinite(operatingCashFlowRatio) || Double.isNaN(operatingCashFlowRatio)) {
            throw new IllegalArgumentException("Invalid input parameters.");
        }
        return operatingCashFlowRatio;
    }

    public double getCashRatio() throws IllegalArgumentException {
        if (currentLiabilities == 0) {
            throw new IllegalArgumentException("Current liabilities cannot be zero.");
        }
        double cashRatio = cashAndCashEquivalents / currentLiabilities;
        if (Double.isInfinite(cashRatio) || Double.isNaN(cashRatio)) {
            throw new IllegalArgumentException("Invalid input parameters.");
        }
        return cashRatio;
    }

    public double getAcidTestRatio() throws IllegalArgumentException {
        if (currentLiabilities == 0) {
            throw new IllegalArgumentException("Current liabilities cannot be zero.");
        }
        double acidTestRatio = (currentAssets - inventories) / currentLiabilities;
        if (Double.isInfinite(acidTestRatio) || Double.isNaN(acidTestRatio)) {
            throw new IllegalArgumentException("Invalid input parameters.");
        }
        return acidTestRatio;
    }

    public double getCurrentRatio() throws IllegalArgumentException {
        if (currentLiabilities == 0) {
            throw new IllegalArgumentException("Current liabilities cannot be zero.");
        }
        double currentRatio = currentAssets / currentLiabilities;
        if (Double.isInfinite(currentRatio) || Double.isNaN(currentRatio)) {
            throw new IllegalArgumentException("Invalid input parameters.");
        }
        return currentRatio;
    }
}