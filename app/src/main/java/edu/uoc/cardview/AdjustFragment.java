package edu.uoc.cardview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.preference.PreferenceFragmentCompat;

public class AdjustFragment extends PreferenceFragmentCompat {

    public AdjustFragment() {

    }
    //Lo emparejamos con el xml preferencias creado....
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {

        setPreferencesFromResource(R.xml.preferences, rootKey);
    }

}