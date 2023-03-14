public class ProfitabilityRatios {
    public static final String[] requiredParams = {
            Constants.NET_INCOME,
            Constants.SHAREHOLDER_EQUITY,
            Constants.TOTAL_ASSETS,
            Constants.OPERATING_INCOME,
            Constants.GROSS_PROFIT,
            Constants.NET_SALES
    };
    private final double netIncome;
    private final double shareholderEquity;
    private final double totalAssets;
    private final double operatingIncome;
    private final double grossProfit;
    private final double netSales;

    public ProfitabilityRatios(
            double netIncome,
            double shareholderEquity,
            double totalAssets,
            double operatingIncome,
            double grossProfit,
            double netSales
    ) throws IllegalArgumentException {
        if (netIncome <= 0 || shareholderEquity <= 0 || totalAssets <= 0 || operatingIncome <= 0 || grossProfit <= 0 || netSales <= 0) {
            throw new IllegalArgumentException("All input parameters must be greater than zero.");
        }

        this.netIncome = netIncome;
        this.shareholderEquity = shareholderEquity;
        this.totalAssets = totalAssets;
        this.operatingIncome = operatingIncome;
        this.grossProfit = grossProfit;
        this.netSales = netSales;
    }

    public double getReturnOnEquityRatio() {
        return netIncome / shareholderEquity;
    }

    public double getReturnOnAssetsRatio() {
        return netIncome / totalAssets;
    }

    public double getOperatingMarginRatio() {
        return operatingIncome / netSales;
    }

    public double getGrossMarginRatio() {
        return grossProfit / netSales;
    }
}