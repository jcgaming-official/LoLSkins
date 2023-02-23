﻿import java.io.BufferedReader;
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
        String apiKey = "RGAPI-e5c5867e-b45f-4307-85bc-fe7759cbd643"; // use your own api by replacing this apikey

        String url = "https://ddragon.leagueoflegends.com/cdn/10.19.1/data/en_US/champion/" + championName + ".json";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        String[] skins = response.toString().split("\"skins\":")[1].split("\"name\":");

        System.out.println("Skin List for Champion: " + championName);
        for (int i = 1; i < skins.length; i++) {
            System.out.println((i) + ". " + skins[i].split("\"")[1]);
        }
    }
}
