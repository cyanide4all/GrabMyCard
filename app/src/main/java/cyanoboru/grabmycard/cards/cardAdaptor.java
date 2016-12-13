package cyanoboru.grabmycard.cards;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by nemboru on 10/12/16.
 */

public class cardAdaptor extends FragmentStatePagerAdapter {

    protected List<String> data;

    public cardAdaptor(FragmentManager m, List<String> data){
        super(m);
        this.data = data;
    }

    @Override
    public Fragment getItem(int position) {
        Bundle b = new Bundle();
        b.putString("name",data.get(position));
        Fragment f = new cardFragment();
        f.setArguments(b);
        return f;
    }

    @Override
    public int getCount() {
        return data.size();
    }
}
