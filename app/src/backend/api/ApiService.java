package dailytaskmanager.backend.api;


import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import java.io.IOException;

public class ApiService {

    public static void login(String username, String password, Callback callback) {
        String url = ApiClient.BASE_URL + /login;

        // Criar o RequestBody com os dados do login
        RequestBody requestBody = new FormBody.Builder()
                .add("username", username)
                .add("password", password)
                .build();

        // Criar a requisição
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        // Executar a requisição
        ApiClient.getClient().newCall(request).enqueue(callback);
    }
}

}

