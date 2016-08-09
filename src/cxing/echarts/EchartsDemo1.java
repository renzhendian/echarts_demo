package cxing.echarts;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("serial")
public class EchartsDemo1 extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response){
		/*解决中文乱码问题*/
		adaptChinese(request,response);

		try{
			JSONObject mainObject=new JSONObject();
			JSONArray array1=new JSONArray();
			array1.put("1月");
			array1.put("2月");
			array1.put("3月");
			array1.put("4月");
			array1.put("5月");
			array1.put("6月");
			mainObject.put("categories", array1);
			JSONArray array2=new JSONArray();
			array2.put(11);
			array2.put(21);
			array2.put(19);
			array2.put(14);
			array2.put(10);
			array2.put(15);
			mainObject.put("data1", array2);
			JSONArray array3=new JSONArray();
			array3.put(8);
			array3.put(16);
			array3.put(20);
			array3.put(18);
			array3.put(16);
			array3.put(19);
			mainObject.put("data2", array3);
			response.getWriter().write(mainObject.toString());
		}catch (IOException | JSONException e) {
			e.printStackTrace();
		}
	}
	
	/**解决中文乱码问题*/
	public void adaptChinese(HttpServletRequest request,HttpServletResponse response){
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
	}
}
