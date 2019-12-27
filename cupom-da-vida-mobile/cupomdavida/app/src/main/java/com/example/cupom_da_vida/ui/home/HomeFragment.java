package com.example.cupom_da_vida.ui.home;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.cupom_da_vida.R;
import com.google.android.material.snackbar.Snackbar;

import java.io.File;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private ImageView imageView;
    private Button tirarFoto;
    private Uri imagemTirada;
    private Button botaoEnviar;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        imageView = root.findViewById(R.id.fotoTirada);
        tirarFoto = root.findViewById(R.id.botaoTirarFoto);
        botaoEnviar = root.findViewById(R.id.botaoEnviar);
        botaoEnviar.setVisibility(View.INVISIBLE);
        botaoEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviar();
            }
        });
        if(ContextCompat.checkSelfPermission(this.getContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this.getActivity(), new String[] { Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE }, 0);
        }
        tirarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fotografar();
            }
        });
        return root;
    }

    public void fotografar() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //imagemTirada = Uri.fromFile(getFotoSaida());
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imagemTirada);
        startActivityForResult(intent, 100);
    }

    public void enviar() {
        Toast.makeText(this.getContext(), "Doação Registrada com Sucesso! Obrigado :)", Toast.LENGTH_LONG).show();
        Snackbar.make(this.getView(), "Doação Registrada com Sucesso! Obrigado :)", Snackbar.LENGTH_LONG).setAction("Action", null).show();
        imageView.setImageBitmap(Bitmap.createBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.graac)));
    }
    public File getFotoSaida() {
        File mediaStore = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "CameraFoto");
        if(!mediaStore.exists()) {
            if(!mediaStore.mkdirs()) {
                return null;
            }
        }
        return new File(mediaStore.getPath() + File.separator + "IMG_" + System.currentTimeMillis() + ".jpg");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 100) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);
            tirarFoto.setVisibility(View.INVISIBLE);
            botaoEnviar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == 0) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                    && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                tirarFoto.setEnabled(true);
            }
        }
    }
}