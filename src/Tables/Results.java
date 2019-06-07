package Tables;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Results {
    public StringProperty result_id;
    public StringProperty voting_id;
    public StringProperty candidate_id;
    public StringProperty num_of_votes;

    public String getResult_id() {
        return result_id.get();
    }

    public StringProperty result_idProperty() {
        return result_id;
    }

    public String getVoting_id() {
        return voting_id.get();
    }

    public StringProperty voting_idProperty() {
        return voting_id;
    }

    public String getCandidate_id() {
        return candidate_id.get();
    }

    public StringProperty candidate_idProperty() {
        return candidate_id;
    }

    public String getNum_of_votes() {
        return num_of_votes.get();
    }

    public StringProperty num_of_votesProperty() {
        return num_of_votes;
    }
    public Results() {}
    public Results(String _result_id, String _voting_id, String _candidate_id, String _num_of_votes)
    {
        result_id = new SimpleStringProperty(_result_id);
        voting_id = new SimpleStringProperty(_voting_id);
        candidate_id = new SimpleStringProperty(_candidate_id);
        num_of_votes = new SimpleStringProperty(_num_of_votes);
    }
}
