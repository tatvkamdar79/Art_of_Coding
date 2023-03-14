public class EfficiencyRatios {
    public static final String[] requiredParams = {
            Constants.INVENTORY_TURNOVER_RATIO,
            Constants.NET_SALES,
            Constants.AVERAGE_INVENTORY,
            Constants.NET_CREDIT_SALES,
            Constants.AVERAGE_ACCOUNTS_RECEIVABLE,
            Constants.COST_OF_GOODS_SOLD,
            Constants.AVERAGE_TOTAL_ASSETS
    };
    private final double inventoryTurnoverRatio;
    private final double netCreditSales;
    private final double averageAccountsReceivable;
    private final double costOfGoodsSold;
    private final double averageInventory;
    private final double netSales;
    private final double averageTotalAssets;

    public EfficiencyRatios(
            double inventoryTurnoverRatio,
            double netSales,
            double averageInventory,
            double netCreditSales,
            double averageAccountsReceivable,
            double costOfGoodsSold,
            double averageTotalAssets
    ) throws IllegalArgumentException {
        if (inventoryTurnoverRatio <= 0 || netSales <= 0 || averageInventory <= 0 || netCreditSales <= 0 || averageAccountsReceivable <= 0 || costOfGoodsSold <= 0 || averageTotalAssets <= 0) {
            throw new IllegalArgumentException("All input parameters must be greater than zero.");
        }

        this.inventoryTurnoverRatio = inventoryTurnoverRatio;
        this.netSales = netSales;
        this.averageInventory = averageInventory;
        this.netCreditSales = netCreditSales;
        this.averageAccountsReceivable = averageAccountsReceivable;
        this.costOfGoodsSold = costOfGoodsSold;
        this.averageTotalAssets = averageTotalAssets;
    }

    public double getDaysSalesInInventoryRatio() {
        return 365.0 / inventoryTurnoverRatio;
    }

    public double getReceivablesTurnoverRatio() {
        return netCreditSales / averageAccountsReceivable;
    }

    public double getInventoryTurnoverRatio() {
        return costOfGoodsSold / averageInventory;
    }

    public double getAssetTurnoverRatio() {
        return netSales / averageTotalAssets;
    }
}