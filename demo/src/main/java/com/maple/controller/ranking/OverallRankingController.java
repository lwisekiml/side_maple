package com.maple.controller.ranking;

import com.maple.service.ranking.RankingService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Controller
@RequestMapping("/ranking")
@RequiredArgsConstructor
public class OverallRankingController {

    private final RankingService rankingService;

    @SneakyThrows
    @GetMapping("/overall")
    public void overall() {
        //////////////////////////////////////////////////////////////////////////////
        String API_KEY = "";
        String characterName = URLEncoder.encode("", StandardCharsets.UTF_8);
        String ocid = "";
        String date = "2023-12-21";

        String urlString = "";
        URL url = new URL(urlString);
        //////////////////////////////////////////////////////////////////////////////

        // HTTP connection 설정
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("x-nxopen-api-key", API_KEY);

        int responseCode = connection.getResponseCode();

        BufferedReader in;
        if(responseCode == 200) {
            // responseCode 200 정상응답
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        } else {
            // responseCode 200 이외의 코드가 반환되었을 경우
            in = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
        }

        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        rankingService.save(response);
    }
}
