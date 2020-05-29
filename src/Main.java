import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HttpClient client = HttpClient.newBuilder()
				.version(Version.HTTP_1_1)
				.build();
		
		HttpRequest request = HttpRequest.newBuilder()
				.GET()
				//.uri(URI.create("http://localhost:4000"))
				.uri(URI.create("http://192.168.0.1/v1/photos/102_2604/IMGP7760.DNG?size=view&storage=sd1"))
				.setHeader("Test", "java wifi k1 client")
				.header("Content-Type", "text/plain")
				.build();
		
		try {
			HttpResponse<Path> response = client.send(request, BodyHandlers.ofFile(Paths.get("C:\\Users\\post4\\Documents\\Entwicklung\\K1_Wifi_Test\\test.DNG")));
			//HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			
			System.out.println(response.statusCode());
			System.out.println(response.headers());
			System.out.println(response.body());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
