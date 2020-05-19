package hcmus.selab.ntan.demolistview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyArrayAdapter extends ArrayAdapter<Hero> {
    Context _context;
    int _layoutResourceID;
    ArrayList<Hero> _heroes;

    public MyArrayAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Hero> objects) {
        super(context, resource, objects);
        _context = context;
        _layoutResourceID = resource;
        _heroes = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null)
        {
            LayoutInflater layoutInflater = LayoutInflater.from(_context);
            convertView = layoutInflater.inflate(_layoutResourceID, parent, false);
        }

        Hero hero = _heroes.get(position);
        ImageView imageView = convertView.findViewById(R.id.imgview_avt);
        TextView txtName = convertView.findViewById(R.id.txtName);
        TextView txtDesc = convertView.findViewById(R.id.txtDesc);
        Bitmap avt = BitmapFactory.decodeResource(_context.getResources(), hero.get_avartarID());
        imageView.setImageBitmap(avt);
        txtName.setText(hero.get_name());
        txtDesc.setText(hero.get_description());

        return super.getView(position, convertView, parent);
    }

    @Override
    public int getCount() {
        return _heroes.size();
    }
}
