package cyanoboru.grabmycard.grid;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import cyanoboru.grabmycard.R;

/**
 * Created by nemboru on 11/12/16.
 */

public class gridAdaptor extends BaseAdapter {

    public List<String> data;
    public Activity c;

    public gridAdaptor(Activity c, List<String> data){
        this.data = data;
        this.c = c;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View t = c.getLayoutInflater().inflate(R.layout.card,null);
        ((TextView) t.findViewById(R.id.cardText)).setText(data.get(position));
        return t;
    }
}
