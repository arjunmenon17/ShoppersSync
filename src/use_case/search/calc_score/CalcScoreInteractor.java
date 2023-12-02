package use_case.search.calc_score;

public class CalcScoreInteractor implements CalcScoreInputBoundary{
    final CalcScoreOutputBoundary calcScoreOutputBoundary;
    final CalcScoreDataAccessInterface calcScoreDataAccessInterface;

    public CalcScoreInteractor (CalcScoreOutputBoundary calcScoreOutputBoundary, CalcScoreDataAccessInterface calcScoreDataAccessInterface) {
        this.calcScoreOutputBoundary = calcScoreOutputBoundary;
        this.calcScoreDataAccessInterface = calcScoreDataAccessInterface;
    }
    @Override
    public void execute(CalcScoreInputData calcScoreInputData) {
        String company = calcScoreInputData.getCompany();

    }
}
