package dailytaskmanager.api;

import okhttp3.OkHttpClient;

public class ApiClient {
    private static final String BASE_URL = http://10.0.2.2:8000
    private static OkHttpClient client;

    public static OkHttpClient getClient() {
        if (client == null) {
            client = new OkHttpClient();
        }
        return client;
    }
}
