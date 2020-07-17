package com.david.datingui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;


import com.david.datingui.databinding.FragmentMatchesBinding;
import com.david.datingui.models.TextMessages;
import com.david.datingui.util.MatchesAdapter;
import com.labo.kaji.fragmentanimations.MoveAnimation;

import java.util.ArrayList;
import java.util.List;

public class MatchesFragment extends Fragment {

    FragmentMatchesBinding binding;
    private NavController navController;
    private MatchesAdapter adapter;
    List<TextMessages> messages=new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        messages.add(new TextMessages("Sandra","1hr Ago","Good Morning David",R.drawable.rsz_images_two));
        messages.add(new TextMessages("Jane Doe","1hr Ago","Good Morning David",R.drawable.rsz_images_one));
        messages.add(new TextMessages("Doe Jane","1hr Ago","Good Morning David",R.drawable.rsz_1images_three));
        messages.add(new TextMessages("David Innocent","1hr Ago","Good Morning David",R.drawable.rsz_images_five));
        messages.add(new TextMessages("Innocent Arisa","1hr Ago","Good Morning David",R.drawable.rsz_lady));



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        navController= Navigation.findNavController(container);
        binding= FragmentMatchesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        adapter=new MatchesAdapter(getContext(),messages);
        binding.messagesRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.messagesRecycler.setHasFixedSize(true);
        binding.messagesRecycler.setAdapter(adapter);



        binding.btnToProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(MatchesFragmentDirections.actionMatchesFragmentToProfileFragment());
            }
        });

        binding.btnToDiscover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(MatchesFragmentDirections.actionMatchesFragmentToMatchFragment());
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding=null;
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        if (enter) {
            return MoveAnimation.create(MoveAnimation.DOWN, enter, 800);
        } else {
            return MoveAnimation.create(MoveAnimation.DOWN, enter, 800);
        }
    }
}