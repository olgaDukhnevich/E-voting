package Tables;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class OwnGroup {
    public StringProperty group_id;
    public StringProperty voting_id;
    public StringProperty group_title;

    public String getVoting_id() {
        return voting_id.get();
    }

    public StringProperty voting_idProperty() {
        return voting_id;
    }

    public String getGroup_id() {
        return group_id.get();
    }

    public StringProperty group_idProperty() {
        return group_id;
    }

    public String getGroup_title() {
        return group_title.get();
    }

    public StringProperty group_titleProperty() {
        return group_title;
    }

    public OwnGroup() {}
    public OwnGroup(String _group_id, String _voting_id, String _group_title)
    {
        group_id = new SimpleStringProperty(_group_id);
        group_title = new SimpleStringProperty(_group_title);
        voting_id = new SimpleStringProperty(_voting_id);
    }
}
