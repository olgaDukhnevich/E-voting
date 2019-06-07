package Tables;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Votes {
    public StringProperty vote_id;
    public StringProperty vote_sign;
    public StringProperty candidate_id;
    public StringProperty voting_id;

    public String getVote_id() {
        return vote_id.get();
    }

    public StringProperty vote_idProperty() {
        return vote_id;
    }

    public String getVote_sign() {
        return vote_sign.get();
    }

    public StringProperty vote_signProperty() {
        return vote_sign;
    }

    public String getCandidate_id() {
        return candidate_id.get();
    }

    public StringProperty candidate_idProperty() {
        return candidate_id;
    }

    public String getVoting_id() {
        return voting_id.get();
    }

    public StringProperty voting_idProperty() {
        return voting_id;
    }
    public Votes( ) {}
    public Votes(String _vote_id, String _vote_sign, String _candidate_id, String _voting_id)
    {
        vote_id = new SimpleStringProperty(_vote_id);
        vote_sign = new SimpleStringProperty(_vote_sign);
        candidate_id = new SimpleStringProperty(_candidate_id);
        voting_id = new SimpleStringProperty(_voting_id);
    }
}
