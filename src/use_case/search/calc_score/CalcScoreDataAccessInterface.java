package use_case.search.calc_score;

public interface CalcScoreDataAccessInterface {
    float get_score_from_file(String company);
    void add_to_productScores(String company, float score);

}
