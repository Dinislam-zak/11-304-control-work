package ru.kpfu.itis.zakirov.controlwork11304.servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import ru.kpfu.itis.zakirov.controlwork11304.http.impl.HttpClientImpl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/weather")
public class WeatherServlet extends HttpServlet {
    HttpClientImpl httpClient = new HttpClientImpl();
    private final String URL = "http://api.openweathermap.org/data/2.5/weather";
    private final String API_KEY = "ec6ae61f58c44f36d3bd7d4f99c9993a";

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String city = req.getParameter("city");

        Map<String, String> params = new HashMap<>();
        params.put("q", city);
        params.put("appid", API_KEY);
        params.put("lang", "en");
        params.put("units", "metric");

        String jsonResponse = httpClient.get(URL, Map.of(), params);

        JSONObject jsonObject = new JSONObject(jsonResponse);

        double temperature = jsonObject.getJSONObject("main").getDouble("temp");

        req.setAttribute("temperature", temperature);

        req.getRequestDispatcher("weather.jsp").forward(req, resp);
    }
}

