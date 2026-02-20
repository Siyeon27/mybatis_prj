package kr.co.sist.car;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import day1226.CarModelDomain;

public class CarService {
	private static CarService cs;
	
	private CarService() {}
	
	public static CarService getInstance() {
		if(cs == null) {
			cs = new CarService();
		}
		
		return cs;
	}
	
	public String searchMaker(String country){
		JSONObject jsonObj = new JSONObject();
		
		jsonObj.put("result", false);
		jsonObj.put("makerCnt", 0);
		
		CarDAO cDAO = CarDAO.getInstance();
		
		try {
			List<String> makerList = cDAO.selectMaker(country);
			jsonObj.put("result", true);
			jsonObj.put("makerCnt", makerList.size());
			
			JSONObject jsonTemp = null;
			JSONArray jsonArr = new JSONArray();
			
			for(String maker : makerList) {
				jsonTemp = new JSONObject();
				
				jsonTemp.put("maker", maker);
				jsonArr.add(jsonTemp);
			}//end for
			
			jsonObj.put("data", jsonArr);
			
		} catch(PersistenceException pe) {
			pe.printStackTrace();
		}//end catch
		
		return jsonObj.toJSONString();
	}
	
	public String searchModel(String maker){
		JSONObject jsonObj = new JSONObject();
		
		jsonObj.put("result", false);
		jsonObj.put("modelCnt", 0);
		
		CarDAO cDAO = CarDAO.getInstance();
		
		try {
			List<String> modelList = cDAO.selectModel(maker);
			jsonObj.put("result", true);
			jsonObj.put("modelCnt", modelList.size());
			
			JSONObject jsonTemp = null;
			JSONArray jsonArr = new JSONArray();
			
			for(String model : modelList) {
				jsonTemp = new JSONObject();
				
				jsonTemp.put("model", model);
				jsonArr.add(jsonTemp);
			}//end for
			
			jsonObj.put("data", jsonArr);
			
		} catch(PersistenceException pe) {
			pe.printStackTrace();
		}//end catch
		
		return jsonObj.toJSONString();
	}
	
	public String searchCar(String model){
		JSONObject jsonObj = new JSONObject();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm");
		String car_option = "";
		
		jsonObj.put("result", false);
		jsonObj.put("carCnt", 0);
		
		CarDAO cDAO = CarDAO.getInstance();
		
		try {
			List<CarModelDomain> carList = cDAO.selectCar(model);
			jsonObj.put("result", true);
			jsonObj.put("carCnt", carList.size());
			
			JSONObject jsonTemp = null;
			JSONArray jsonArr = new JSONArray();
			
			for(CarModelDomain cmd : carList) {
				jsonTemp = new JSONObject();
				car_option = cmd.getCar_option();
				
				if(car_option != null && car_option.length() > 20) {
					car_option = car_option.substring(0, 19) + "...";
				}
				
				jsonTemp.put("car_img", cmd.getCar_img());
				jsonTemp.put("car_option", car_option == null ? "옵션 없음" : car_option);
				jsonTemp.put("car_year", cmd.getCar_year());
				jsonTemp.put("price", cmd.getPrice());
				jsonTemp.put("cc", cmd.getCc());
				jsonTemp.put("input_date", sdf.format(cmd.getInput_date()));
				
				jsonArr.add(jsonTemp);
			}//end for
			
			jsonObj.put("data", jsonArr);
			
		} catch(PersistenceException pe) {
			pe.printStackTrace();
		}//end catch
		
		return jsonObj.toJSONString();
	}
	
}
