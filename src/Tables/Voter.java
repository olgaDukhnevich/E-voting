package Tables;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Voter {
    public StringProperty voter_id;
    public StringProperty pub_key;
    public StringProperty voting_id;

    public String getVoter_id() {
        return voter_id.get();
    }

    public StringProperty voter_idProperty() {
        return voter_id;
    }

    public String getPub_key() {
        return pub_key.get();
    }

    public StringProperty pub_keyProperty() {
        return pub_key;
    }

    public String getVoting_id() {
        return voting_id.get();
    }

    public StringProperty voting_idProperty() {
        return voting_id;
    }

    public Voter() {}
    public Voter(String _voter_id, String _pub_key, String _voting_id)
    {
        voter_id = new SimpleStringProperty(_voter_id);
        pub_key = new SimpleStringProperty(_pub_key);
        voting_id = new SimpleStringProperty(_voting_id);
    }
}
