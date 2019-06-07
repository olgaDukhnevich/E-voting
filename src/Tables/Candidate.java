package Tables;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Candidate {
    public StringProperty candidate_id;
    public StringProperty FIO;
    public StringProperty about;
    public StringProperty voting_id;
    public StringProperty cand_login;

    public String getCandidate_id() {
        return candidate_id.get();
    }

    public StringProperty candidate_idProperty() {
        return candidate_id;
    }

    public String getFIO() {
        return FIO.get();
    }

    public StringProperty FIOProperty() {
        return FIO;
    }

    public String getAbout() {
        return about.get();
    }

    public StringProperty aboutProperty() {
        return about;
    }

    public String getVoting_id() {
        return voting_id.get();
    }

    public StringProperty voting_idProperty() {
        return voting_id;
    }

    public String getCand_login() {
        return cand_login.get();
    }

    public StringProperty cand_loginProperty() {
        return cand_login;
    }

    public Candidate(){}
    public Candidate(String _candidate_id, String _FIO, String _about, String _voting_id, String _cand_login)
    {
        candidate_id = new SimpleStringProperty(_candidate_id);
        FIO = new SimpleStringProperty(_FIO);
        about =  new SimpleStringProperty(_about);
        voting_id = new SimpleStringProperty(_voting_id);
        cand_login =  new SimpleStringProperty(_cand_login);
    }
}
