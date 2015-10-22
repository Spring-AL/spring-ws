package hello.controller;

import hello.WeatherClient;
import hello.wsdl.GetCityForecastByZIPResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/")
public class TesteWebService {
	
	@Autowired
	private WeatherClient client;

	@RequestMapping(value="teste", method= RequestMethod.GET)
	@ResponseBody
	public String index(){
		GetCityForecastByZIPResponse response = client.getCityForecastByZip("94304");
		return response.getGetCityForecastByZIPResult().getCity() + " - " + response.getGetCityForecastByZIPResult().getState();
	}
	
	

}
