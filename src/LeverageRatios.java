public class LeverageRatios {
    public static final String[] requiredParams = {
            Constants.OPERATING_INCOME,
            Constants.TOTAL_DEBT_SERVICE,
            Constants.INTEREST_EXPENSES,
            Constants.TOTAL_LIABILITIES,
            Constants.SHAREHOLDER_EQUITY,
            Constants.TOTAL_ASSETS
    };
    private final double operatingIncome;
    private final double totalDebtService;
    private final double interestExpenses;
    private final double totalLiabilities;
    private final double shareholderEquity;
    private final double totalAssets;

    public LeverageRatios(double operatingIncome, double totalDebtService, double interestExpenses,
                          double totalLiabilities, double shareholderEquity, double totalAssets) throws IllegalArgumentException {
        if (operatingIncome <= 0 || totalDebtService <= 0 || interestExpenses <= 0 || totalLiabilities <= 0 || shareholderEquity <= 0 || totalAssets <= 0) {
            throw new IllegalArgumentException("All input parameters must be greater than zero.");
        }
        this.operatingIncome = operatingIncome;
        this.totalDebtService = totalDebtService;
        this.interestExpenses = interestExpenses;
        this.totalLiabilities = totalLiabilities;
        this.shareholderEquity = shareholderEquity;
        this.totalAssets = totalAssets;
    }

    public double getDebtServiceCoverageRatio() throws IllegalArgumentException {
        if (totalDebtService <= 0) {
            throw new IllegalArgumentException("Total debt service must be greater than zero.");
        }
        double debtServiceCoverageRatio = operatingIncome / totalDebtService;
        if (Double.isInfinite(debtServiceCoverageRatio) || Double.isNaN(debtServiceCoverageRatio)) {
            throw new IllegalArgumentException("Invalid input parameters.");
        }
        return debtServiceCoverageRatio;
    }

    public double getInterestCoverageRatio() throws IllegalArgumentException {
        if (interestExpenses <= 0) {
            throw new IllegalArgumentException("Interest expenses must be greater than zero.");
        }
        double interestCoverageRatio = operatingIncome / interestExpenses;
        if (Double.isInfinite(interestCoverageRatio) || Double.isNaN(interestCoverageRatio)) {
            throw new IllegalArgumentException("Invalid input parameters.");
        }
        return interestCoverageRatio;
    }

    public double getDebtToEquityRatio() throws IllegalArgumentException {
        if (shareholderEquity <= 0) {
            throw new IllegalArgumentException("Shareholder’s equity must be greater than zero.");
        }
        double debtToEquityRatio = totalLiabilities / shareholderEquity;
        if (Double.isInfinite(debtToEquityRatio) || Double.isNaN(debtToEquityRatio)) {
            throw new IllegalArgumentException("Invalid input parameters.");
        }
        return debtToEquityRatio;
    }

    public double getDebtRatio() throws IllegalArgumentException {
        if (totalAssets <= 0) {
            throw new IllegalArgumentException("Total assets must be greater than zero.");
        }
        double debtRatio = totalLiabilities / totalAssets;
        if (Double.isInfinite(debtRatio) || Double.isNaN(debtRatio)) {
            throw new IllegalArgumentException("Invalid input parameters.");
        }
        return debtRatio;
    }
}