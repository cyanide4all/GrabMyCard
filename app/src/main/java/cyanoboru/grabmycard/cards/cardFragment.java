package cyanoboru.grabmycard.cards;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cyanoboru.grabmycard.R;

/**
 * Created by nemboru on 10/12/16.
 */

public class cardFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.card, container, false);
        Bundle b = getArguments();
        ((TextView) rootView.findViewById(R.id.cardText)).setText(b.getString("name"));
        return rootView;
    }
}
