package hcmus.selab.ntan.demolistview;

public class Hero {
    String _name;
    int _avartarID;
    String _description;

    public Hero(String name, int avatarID, String description) {
        _name = name;
        _avartarID = avatarID;
        _description = description;
    }

    public String get_name() {
        return _name;
    }

    public int get_avartarID() {
        return _avartarID;
    }

    public String get_description() {
        return _description;
    }

    public void set_name(String name) {
        this._name = name;
    }

    public void set_avartarID(int avartarID) {
        this._avartarID = avartarID;
    }

    public void set_description(String description) {
        this._description = description;
    }

}
