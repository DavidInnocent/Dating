package com.david.datingui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;


import com.david.datingui.databinding.FragmentAddPhotoBinding;
import com.david.datingui.util.ImageAdapter;
import com.labo.kaji.fragmentanimations.MoveAnimation;

import java.util.ArrayList;
import java.util.List;

public class addPhotoFragment extends Fragment {


    private NavController navController;
    FragmentAddPhotoBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        navController= Navigation.findNavController(container);

        binding=FragmentAddPhotoBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        binding.btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_addPhotoFragment_to_selectTypeFragment);
            }
        });

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(getContext(),R.array.values_array,android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        binding.age.setAdapter(adapter);
        binding.heightt.setAdapter(adapter);
        binding.weightt.setAdapter(adapter);

        LinearLayoutManager layoutManager=new LinearLayoutManager(view.getContext());
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        binding.recyclerView.setLayoutManager(layoutManager);

        List<Integer> images=new ArrayList<>();
        images.add(R.drawable.rsz_images_one);
        images.add(R.drawable.rsz_images_two);
        images.add(R.drawable.rsz_1images_three);
        images.add(R.drawable.rsz_images_four);
        ImageAdapter imageAdapter=new ImageAdapter(images,getContext());
        imageAdapter.setHasStableIds(true);
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setAdapter(imageAdapter);

    }


    @Override
    public void onResume() {
        super.onResume();
        if (getActivity() != null && getActivity().getWindow() != null) {
            getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        if (getActivity() != null && getActivity().getWindow() != null) {
            getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            getActivity().getWindow().getDecorView().setSystemUiVisibility(0);
        }

    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        if (enter) {
            return MoveAnimation.create(MoveAnimation.UP, enter, 800);
        } else {
            return MoveAnimation.create(MoveAnimation.DOWN, enter, 900);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding=null;
    }
}