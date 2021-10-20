package org.idnp.mvvmsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import org.idnp.mvvmsample.databinding.ActivityVisitBinding;
import org.idnp.mvvmsample.viewmodels.VisitViewModel;

public class Visit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityVisitBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_visit);
        binding.setViewVisit(new VisitViewModel(this));
        binding.executePendingBindings();

    }
}