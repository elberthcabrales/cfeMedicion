package com.example.hp.hellowwordl;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EmulatorFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EmulatorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EmulatorFragment extends Fragment implements View.OnClickListener{

    Chronometer chronoKw=null;
    Button btnstartEkw= null;
    Button btnstopEkw=null;

    Chronometer chronoKvarh=null;
    Button btnstartkvarh= null;
    Button btnstoptkvarh=null;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public EmulatorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EmulatorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EmulatorFragment newInstance(String param1, String param2) {
        EmulatorFragment fragment = new EmulatorFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_emulator, container, false);
        chronoKw = (Chronometer) view.findViewById(R.id.chronoEkwh);
        btnstartEkw = (Button) view.findViewById(R.id.btnStarteEKw);
        btnstopEkw= (Button) view.findViewById(R.id.btnStopEKw);

        chronoKvarh = (Chronometer) view.findViewById(R.id.chronoEkvarh);
        btnstartkvarh = (Button) view.findViewById(R.id.btnStarteEkvarh);
        btnstoptkvarh= (Button) view.findViewById(R.id.btnStopEKvarh);

        btnstoptkvarh.setOnClickListener(this);
        btnstartkvarh.setOnClickListener(this);

        btnstopEkw.setOnClickListener(this);
        btnstartEkw.setOnClickListener(this);

        if(savedInstanceState!=null){
            chronoKw.setBase(savedInstanceState.getLong("cronokwbase"));

        }
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnStarteEKw:
                chronoKw.setBase(SystemClock.elapsedRealtime());
                chronoKw.start();
                btnstartEkw.setText("Reiniciar");
                break;
            case R.id.btnStopEKw:
                //chrono.setBase(SystemClock.elapsedRealtime());
                chronoKw.stop();
                btnstartEkw.setText("Iniciar");
                break;
            case R.id.btnStarteEkvarh:
                chronoKvarh.setBase(SystemClock.elapsedRealtime());
                chronoKvarh.start();
                btnstartkvarh.setText("Reiniciar");
                break;
            case R.id.btnStopEKvarh:
                chronoKvarh.stop();
                btnstartkvarh.setText("Iniciar");
                break;
        }
    }
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putLong("cronokwbase", chronoKw.getBase());
        super.onSaveInstanceState(outState);
    }


}
