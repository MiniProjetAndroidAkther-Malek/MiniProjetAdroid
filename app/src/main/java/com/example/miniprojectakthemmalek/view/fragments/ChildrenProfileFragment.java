package com.example.miniprojectakthemmalek.view.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.miniprojectakthemmalek.R;
import com.example.miniprojectakthemmalek.model.entities.Children;
import com.example.miniprojectakthemmalek.model.repositories.ChildrenRepository;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;


public class ChildrenProfileFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    int id;
    TextView descriptionProfileChildren,birthdayChildrenProfile,childrenNameProfile;
    FloatingActionButton fab;
    String connectedUsername;
    public ChildrenProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChildrenProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChildrenProfileFragment newInstance(String param1, String param2) {
        ChildrenProfileFragment fragment = new ChildrenProfileFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_children_profile, container, false);
        id=getArguments().getInt("id");
        descriptionProfileChildren=rootView.findViewById(R.id.descriptionProfileChildren);
        birthdayChildrenProfile=rootView.findViewById(R.id.birthdayChildrenProfile);
        childrenNameProfile=rootView.findViewById(R.id.childrenNameProfile);
        fab=rootView.findViewById(R.id.fab);
        connectedUsername=getArguments().getString("connectedUsername");

        ChildrenRepository.getInstance().getChildrenById(id, new ChildrenRepository.getAllCallBack() {
            @Override
            public void onResponse(List<Children> childrenList) {
                if(childrenList.size()!=0)
                {
                    Children children=childrenList.get(0);
                    if(children.getParent().equals(connectedUsername))
                    {
                        fab.setVisibility(View.VISIBLE);
                    }
                    descriptionProfileChildren.setText(children.getDescription().toString());
                    birthdayChildrenProfile.setText(children.getBirthday().toString().substring(0,10));
                    childrenNameProfile.setText(children.getName().toString());
                }

            }
        });


        return rootView;
    }



}
