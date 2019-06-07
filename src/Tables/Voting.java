package Tables;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.stream.Stream;

public class Voting {
    public StringProperty voting_id;
    public StringProperty title;
    public StringProperty voting_type;
    public StringProperty purpose;
    public StringProperty start_voting;
    public StringProperty end_voting;
    public StringProperty num_of_voters;

    public String getVoting_id() {
        return voting_id.get();
    }

    public StringProperty voting_idProperty() {
        return voting_id;
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }
    public String getVoting_type()
    {
        return voting_type.get();
    }

    public StringProperty voting_typeProperty() {
        return voting_type;
    }

    public String getPurpose() {
        return purpose.get();
    }

    public StringProperty purposeProperty() {
        return purpose;
    }

    public String getStart_voting() {
        return start_voting.get();
    }

    public StringProperty start_votingProperty() {
        return start_voting;
    }

    public String getEnd_voting() {
        return end_voting.get();
    }

    public StringProperty end_votingProperty() {
        return end_voting;
    }

    public String getNum_of_voters() {
        return num_of_voters.get();
    }

    public StringProperty num_of_votersProperty() {
        return num_of_voters;
    }

    public Voting() {}

    public Voting(String _voting_id, String _title, String _voting_type, String _purpose, String _start_voting, String _end_voting, String _num_of_voters)
    {
        voting_id = new SimpleStringProperty(_voting_id);
        title = new SimpleStringProperty(_title);
        voting_type = new SimpleStringProperty(_voting_type);
        purpose = new SimpleStringProperty(_purpose);
        start_voting = new SimpleStringProperty(_start_voting);
        end_voting = new SimpleStringProperty(_end_voting);
        num_of_voters = new SimpleStringProperty(_num_of_voters);
    }
}

