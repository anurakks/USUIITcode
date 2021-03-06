package it_anurak.co.th.usuiitcode;


import android.app.DownloadManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ServiceFragment extends Fragment {

    private String resultString = "";


    public ServiceFragment() {
        // Required empty public constructor
    }

    public static ServiceFragment serviceInstance(String resultString){
        ServiceFragment serviceFragment = new ServiceFragment();
        Bundle bundle = new Bundle();
        bundle.putString("Result",resultString);
        serviceFragment.setArguments(bundle);

        return serviceFragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        resultString = getArguments().getString("Result", "");
        TextView textView = getView().findViewById(R.id.txtResult);
        textView.setText(resultString);

//        QR Controll
          QRControll();


    }

    private void QRControll() {
        Button button = getView().findViewById(R.id.btnQR);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.ContentMainFragment, new QRCodeFragment()  )
                        .addToBackStack(null)
                        .commit();
            }
        });
    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_service, container, false);
    }

}
