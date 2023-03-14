import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        Map<String, Double> financialData = new HashMap<>(); // = getDataFromUser();
        financialData.put(Constants.OPERATING_CASH_FLOW, 10000.0);
        financialData.put(Constants.CASH_AND_CASH_EQUIVALENTS, 5000.0);
        financialData.put(Constants.CURRENT_ASSETS, 20000.0);
        financialData.put(Constants.INVENTORIES, 5000.0);
        financialData.put(Constants.CURRENT_LIABILITIES, 10000.0);
        financialData.put(Constants.OPERATING_INCOME, 15000.0);
        financialData.put(Constants.TOTAL_DEBT_SERVICE, 1000.0);
        financialData.put(Constants.INTEREST_EXPENSES, 2000.0);
        financialData.put(Constants.TOTAL_LIABILITIES, 30000.0);
        financialData.put(Constants.SHAREHOLDER_EQUITY, 20000.0);
        financialData.put(Constants.TOTAL_ASSETS, 50000.0);
        financialData.put(Constants.INVENTORY_TURNOVER_RATIO, 8.0);
        financialData.put(Constants.NET_CREDIT_SALES, 40000.0);
        financialData.put(Constants.AVERAGE_ACCOUNTS_RECEIVABLE, 5000.0);
        financialData.put(Constants.COST_OF_GOODS_SOLD, 20000.0);
        financialData.put(Constants.AVERAGE_INVENTORY, 6000.0);
        financialData.put(Constants.NET_SALES, 50000.0);
        financialData.put(Constants.AVERAGE_TOTAL_ASSETS, 45000.0);
        financialData.put(Constants.NET_INCOME, 10000.0);
        financialData.put(Constants.GROSS_PROFIT, 25000.0);

        Set<RatioType> ratioTypes = new HashSet<>();
        ratioTypes.add(RatioType.LIQUIDITY);
        ratioTypes.add(RatioType.LEVERAGE);
        ratioTypes.add(RatioType.EFFICIENCY);
        ratioTypes.add(RatioType.PROFITABILITY);

        FinancialCalculator calculator = new FinancialCalculator(financialData, ratioTypes);
        calculator.displayAllFinancialRatios();
    }

    public static HashMap<String, Double> getDataFromUser() {
        HashMap<String, Double> financialData = new HashMap<String, Double>();
        Scanner scanner = new Scanner(System.in);

        String[] variableNames = {
                Constants.OPERATING_CASH_FLOW,
                Constants.CASH_AND_CASH_EQUIVALENTS,
                Constants.CURRENT_ASSETS,
                Constants.INVENTORIES,
                Constants.CURRENT_LIABILITIES,
                Constants.OPERATING_INCOME,
                Constants.TOTAL_DEBT_SERVICE,
                Constants.INTEREST_EXPENSES,
                Constants.TOTAL_LIABILITIES,
                Constants.SHAREHOLDER_EQUITY,
                Constants.TOTAL_ASSETS,
                Constants.INVENTORY_TURNOVER_RATIO,
                Constants.NET_CREDIT_SALES,
                Constants.AVERAGE_ACCOUNTS_RECEIVABLE,
                Constants.COST_OF_GOODS_SOLD,
                Constants.AVERAGE_INVENTORY,
                Constants.NET_SALES,
                Constants.AVERAGE_TOTAL_ASSETS,
                Constants.NET_INCOME,
                Constants.GROSS_PROFIT
        };

        for (String variableName : variableNames) {
            System.out.print("Enter value for " + variableName + ": ");
            Double value = scanner.nextDouble();
            scanner.nextLine();
            financialData.put(variableName, value);
        }

        return financialData;
    }
}
