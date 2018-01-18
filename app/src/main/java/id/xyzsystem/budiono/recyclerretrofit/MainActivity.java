package id.xyzsystem.budiono.recyclerretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/* mulai declare dari sini */
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.util.ArrayList;
import java.util.Arrays;
import android.util.Log;


public class MainActivity extends AppCompatActivity {
    private RecyclerView a_recyclerView;
    private ArrayList<ObjectData> j_data;
    private AdapterData k_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* todo (): create function  */
        initViews();

    }
    private void initViews(){
        /* todo (): declare recyclerview, LinearLayoutManager  */
        a_recyclerView = (RecyclerView)findViewById(R.id.kartu_recycler_view);
        a_recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        a_recyclerView.setLayoutManager(layoutManager);
        panggil_JSON();
    }
    private void panggil_JSON(){
        /* todo (): lib retrofit, GsonConverterFactory */
        Retrofit b_retrofit = new Retrofit.Builder()
                .baseUrl("http://api.learn2crack.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        /* todo (): ServerInterface, ServerResponse, Call */
        ServerInterface c_request = b_retrofit.create(ServerInterface.class);
        Call<ServerResponse> f_call = c_request.d_respon();

        /* todo () : Callback */
        f_call.enqueue(new Callback<ServerResponse>() {
            /* todo() : Declare Call, Response*/
            @Override
            public void onResponse(Call<ServerResponse> g_call, Response<ServerResponse> h_response) {

                ServerResponse i_ServerResponse = h_response.body();

                /* todo() : declare ArrayList, Arrays */
                j_data = new ArrayList<>(Arrays.asList(i_ServerResponse.getAndroid()));

                /* todo() : declare AdapterData */
                k_adapter = new AdapterData(j_data);
                a_recyclerView.setAdapter(k_adapter);
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                /* todo(): declare Log */
                Log.d("Error",t.getMessage());
            }
        });

    }
}
