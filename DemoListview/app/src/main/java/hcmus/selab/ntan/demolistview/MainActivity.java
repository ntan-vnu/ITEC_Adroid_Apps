package hcmus.selab.ntan.demolistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<Hero> _listHeroes;
    ListView _listview;
    MyArrayAdapter _myArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateData();
        initListView();
    }

    private void initListView() {
        _myArrayAdapter = new MyArrayAdapter(getBaseContext(), R.layout.item_listview, _listHeroes);
        _listview = findViewById(R.id.lst_heroes);
        _listview.setAdapter(_myArrayAdapter);
    }

    private void generateData() {
        _listHeroes = new ArrayList<>();
        _listHeroes.add(new Hero("Ahri", R.drawable.ahri, "This is a dummy description..."));
        _listHeroes.add(new Hero("Ashe", R.drawable.ashe, "This is a dummy description..."));
        _listHeroes.add(new Hero("Brand", R.drawable.brand, "This is a dummy description..."));
        _listHeroes.add(new Hero("Elise", R.drawable.elise, "This is a dummy description..."));
        _listHeroes.add(new Hero("Hecarim", R.drawable.hecarim, "This is a dummy description..."));
        _listHeroes.add(new Hero("Janna", R.drawable.janna, "This is a dummy description..."));
        _listHeroes.add(new Hero("Leblanc", R.drawable.leblanc, "This is a dummy description..."));
        _listHeroes.add(new Hero("Masteryi", R.drawable.masteryi, "This is a dummy description..."));
        _listHeroes.add(new Hero("Nasus", R.drawable.nasus, "This is a dummy description..."));
        _listHeroes.add(new Hero("Tryndamere", R.drawable.tryndamere, "This is a dummy description..."));

    }
}
