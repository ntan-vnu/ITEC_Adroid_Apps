package hcmus.selab.ntan.demomaps;

import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.LatLng;

public class Place {
    private LatLng _latlng;
    private String _title;
    private String _description;
//    private BitmapDescriptor _icon_desc;

    public Place(LatLng loc, String title, String desc) {
        _latlng = loc;
        _title = title;
        _description = desc;
    }
    public LatLng getLatlng() {
        return _latlng;
    }

    public void setLatlng(LatLng latlng) {
        this._latlng = latlng;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        this._title = title;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        this._description = description;
    }
}
