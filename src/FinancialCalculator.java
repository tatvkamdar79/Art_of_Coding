import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class FinancialCalculator {
    private LiquidityRatios liquidityRatios;
    private LeverageRatios leverageRatios;
    private EfficiencyRatios efficiencyRatios;
    private final ProfitabilityRatios profitabilityRatios;

    private double operatingCashFlow;
    private double cashAndCashEquivalents;
    private double currentAssets;
    private double inventories;
    private double currentLiabilities;

    private double operatingIncome;
    private double totalDebtService;
    private double interestExpenses;
    private double totalLiabilities;
    private double shareholderEquity;
    private double totalAssets;

    private double inventoryTurnoverRatio;
    private double netSales;
    private double averageInventory;
    private double netCreditSales;
    private double averageAccountsReceivable;
    private double costOfGoodsSold;
    private double averageTotalAssets;

    private final double netIncome;
    //shareholderEquity;
    //totalAssets;
    //operatingIncome;
    private final double grossProfit;
    //netSales;

    public FinancialCalculator(Map<String, Double> inputs, Set<RatioType> ratioTypes) throws Exception {

        if (ratioTypes.contains(RatioType.LIQUIDITY)) {
            if (!checkIfExistsAndValidate(inputs, LiquidityRatios.requiredParams)) {
                throw new IllegalArgumentException("Required Params Missing!\n Here is a list of required params" + Arrays.toString(LiquidityRatios.requiredParams));
            }
            operatingCashFlow = inputs.get(Constants.OPERATING_CASH_FLOW);
            cashAndCashEquivalents = inputs.get(Constants.CASH_AND_CASH_EQUIVALENTS);
            currentAssets = inputs.get(Constants.CURRENT_ASSETS);
            inventories = inputs.get(Constants.INVENTORIES);
            currentLiabilities = inputs.get(Constants.CURRENT_LIABILITIES);
            this.liquidityRatios = new LiquidityRatios(currentLiabilities, operatingCashFlow, cashAndCashEquivalents,
                    currentAssets, inventories);
        }
        if (ratioTypes.contains(RatioType.LEVERAGE)) {
            if (!checkIfExistsAndValidate(inputs, LeverageRatios.requiredParams)) {
                throw new IllegalArgumentException("Required Params Missing!\n Here is a list of required params" + Arrays.toString(LeverageRatios.requiredParams));
            }
            operatingIncome = inputs.get(Constants.OPERATING_INCOME);
            totalDebtService = inputs.get(Constants.TOTAL_DEBT_SERVICE);
            interestExpenses = inputs.get(Constants.INTEREST_EXPENSES);
            totalLiabilities = inputs.get(Constants.TOTAL_LIABILITIES);
            shareholderEquity = inputs.get(Constants.SHAREHOLDER_EQUITY);
            totalAssets = inputs.get(Constants.TOTAL_ASSETS);
            this.leverageRatios = new LeverageRatios(operatingIncome, interestExpenses, totalDebtService,
                    totalLiabilities, shareholderEquity, totalAssets);
        }
        if (ratioTypes.contains(RatioType.EFFICIENCY)) {
            if (!checkIfExistsAndValidate(inputs, EfficiencyRatios.requiredParams)) {
                throw new IllegalArgumentException("Required Params Missing!\n Here is a list of required params" + Arrays.toString(EfficiencyRatios.requiredParams));
            }
            inventoryTurnoverRatio = inputs.get(Constants.INVENTORY_TURNOVER_RATIO);
            netSales = inputs.get(Constants.NET_SALES);
            averageInventory = inputs.get(Constants.AVERAGE_INVENTORY);
            netCreditSales = inputs.get(Constants.NET_CREDIT_SALES);
            averageAccountsReceivable = inputs.get(Constants.AVERAGE_ACCOUNTS_RECEIVABLE);
            costOfGoodsSold = inputs.get(Constants.COST_OF_GOODS_SOLD);
            averageTotalAssets = inputs.get(Constants.AVERAGE_TOTAL_ASSETS);
            this.efficiencyRatios = new EfficiencyRatios(inventoryTurnoverRatio, netSales, averageInventory,
                    netCreditSales, averageAccountsReceivable, costOfGoodsSold, averageTotalAssets);
        }
        if (ratioTypes.contains(RatioType.PROFITABILITY)) {
            if (!checkIfExistsAndValidate(inputs, ProfitabilityRatios.requiredParams)) {
                throw new IllegalArgumentException("Required Params Missing!\n Here is a list of required params" + Arrays.toString(ProfitabilityRatios.requiredParams));
            }
            netIncome = inputs.get(Constants.NET_INCOME);
            grossProfit = inputs.get(Constants.GROSS_PROFIT);
            this.profitabilityRatios = new ProfitabilityRatios(netIncome, shareholderEquity, totalAssets,
                    operatingIncome, grossProfit, netSales);
        } else {
            throw new IllegalArgumentException("Invalid RatioType");
        }
    }

    private boolean checkIfExistsAndValidate(Map<String, Double> inputs, String[] requiredParams) {
        for (String param : requiredParams) {
            if (!inputs.containsKey(param)) {
                return false;
            }
            if (inputs.get(param) <= 0) {
                throw new IllegalArgumentException("Invalid value of " + param + "!\nValue cannot be less than 0");
            }
        }
        return true;
    }

    public void displayLiquidityRatios() {
        if (this.liquidityRatios == null)
            throw new IllegalArgumentException("Variables for Liquidity Ratio not declared");
        System.out.println("Liquidity Ratios:");
        System.out.println("------------------------------");
        System.out.println("Operating Cash Flow Ratio: " + liquidityRatios.getOperatingCashFlowRatio());
        System.out.println("Cash Ratio: " + liquidityRatios.getCashRatio());
        System.out.println("Acid-Test Ratio: " + liquidityRatios.getAcidTestRatio());
        System.out.println("Current Ratio: " + liquidityRatios.getCurrentRatio());
        System.out.println("------------------------------");
    }

    public void displayLeverageRatios() {
        if (this.leverageRatios == null)
            throw new IllegalArgumentException("Variables for Liquidity Ratio not declared");
        System.out.println("Leverage Ratios:");
        System.out.println("------------------------------");
        System.out.printf("Debt Service Coverage Ratio: %.2f\n", leverageRatios.getDebtServiceCoverageRatio());
        System.out.printf("Interest Coverage Ratio: %.2f\n", leverageRatios.getInterestCoverageRatio());
        System.out.printf("Debt to Equity Ratio: %.2f\n", leverageRatios.getDebtToEquityRatio());
        System.out.printf("Debt Ratio: %.2f\n", leverageRatios.getDebtRatio());
        System.out.println("------------------------------\n");
    }

    public void displayEfficiencyRatios() {
        if (this.efficiencyRatios == null)
            throw new IllegalArgumentException("Variables for Liquidity Ratio not declared");
        System.out.println("Efficiency Ratios:");
        System.out.println("------------------------------");
        System.out.printf("Days Sales in Inventory Ratio: %.2f days%n",
                efficiencyRatios.getDaysSalesInInventoryRatio());
        System.out.printf("Receivables Turnover Ratio: %.2f%n", efficiencyRatios.getReceivablesTurnoverRatio());
        System.out.printf("Inventory Turnover Ratio: %.2f%n", efficiencyRatios.getInventoryTurnoverRatio());
        System.out.printf("Asset Turnover Ratio: %.2f%n", efficiencyRatios.getAssetTurnoverRatio());
        System.out.println("------------------------------");
    }

    public void displayProfitabilityRatios() {
        if (this.profitabilityRatios == null)
            throw new IllegalArgumentException("Variables for Liquidity Ratio not declared");
        System.out.println("Profitability Ratios:");
        System.out.println("------------------------------");
        System.out.printf("Return on Equity Ratio: %.2f%%%n", profitabilityRatios.getReturnOnEquityRatio() * 100);
        System.out.printf("Return on Assets Ratio: %.2f%%%n", profitabilityRatios.getReturnOnAssetsRatio() * 100);
        System.out.printf("Operating Margin Ratio: %.2f%%%n", profitabilityRatios.getOperatingMarginRatio() * 100);
        System.out.printf("Gross Margin Ratio: %.2f%%%n", profitabilityRatios.getGrossMarginRatio() * 100);
        System.out.println("------------------------------");

    }

    public void displayAllFinancialRatios() {
        displayLiquidityRatios();
        displayLeverageRatios();
        displayEfficiencyRatios();
        displayProfitabilityRatios();
    }

}