import okhttp3.*;

public class CoreNLPExample {
   public static void main(String[] args) throws java.io.IOException {
   // The text to annotate
   String text = "The fox jumped over the lazy dog";

   // Create an OkHttp Client with authentication
   OkHttpClient client = new OkHttpClient.Builder()
      .authenticator((route, response) -> {
         String credential = Credentials.basic("api_key", "api_secret");
         return response.request().newBuilder().header("Authorization", credential).build();
         })
      .build();

   // Issue a request
   Request request = new Request.Builder()
      .url("https://corenlp.ai")
      .post(RequestBody.create(MediaType.parse("text/plain; charset=utf-8"), text))
      .build();

      // Read the JSON response
      Response response = client.newCall(request).execute();
      String json = response.body().string();

      System.out.println(json);
   }
}
