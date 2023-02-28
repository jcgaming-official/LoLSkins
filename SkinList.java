import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class SkinList {
    public static void main(String[] args) throws Exception {
        System.out.println("Hi, Welcome to League of Legends Skinlist!");
        Thread.sleep(5000);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the champion name:");
        String championName = sc.nextLine();

        String apiKey = "RGAPI-e5c5867e-b45f-4307-85bc-me49nfla03ja";
        String url = "https://ddragon.leagueoflegends.com/cdn/13.4.1/data/en_US/champion/" + championName + ".json?api_key=" + apiKey;

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET");

        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            String[] skins = response.toString().split("\"skins\":\\[")[1].split("\\},\\{");

            System.out.println("Skin List for Champion: " + championName);
            for (int i = 0; i < skins.length; i++) {
                String skinName = skins[i].split("\"name\":\"")[1].split("\"")[0];
                System.out.println((i + 1) + ". " + skinName);
            }
        }
    }
}
