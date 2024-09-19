package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/weather")
public class WeatherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String API_KEY = "515a00b80069e107f1818497c69f1d0a"; // ここにあなたのAPIキーを入力
	private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String city = "Tokyo"; // 取得したい都市名
		String response1 = getWeatherData(city);

		if (response1 != null) {
			request.setAttribute("weatherData", response1);
		}

		else {
			request.setAttribute("errorMessage", "Failed to retrieve weather data.");
		}
		request
				.getRequestDispatcher("/WEB-INF/view/weather.jsp")
				.forward(request, response);
	}

	private static String getWeatherData(String city) {
		StringBuilder result = new StringBuilder();
		try {
			// API URLを構築
			String urlString = API_URL + "?q=" + city + "&appid=" + API_KEY + "&units=metric";
			URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET"); // GETリクエストを設定

			// レスポンスを読み取る
			try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
				String line;
				while ((line = in.readLine()) != null) {
					result.append(line);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null; // 取得失敗の場合はnullを返す
		}
		return result.toString();
	}// 取得したデータを返す

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
