package id.xyzsystem.budiono.recyclerretrofit;

/**
 * Created by budiono on 18/01/18.
 */

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServerInterface {
    @GET("android/jsonandroid")
    Call<ServerResponse> d_respon();
}
