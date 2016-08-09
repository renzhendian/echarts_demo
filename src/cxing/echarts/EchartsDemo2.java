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
public class EchartsDemo2 extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response){
		/*解决中文乱码问题*/
		adaptChinese(request,response);

		try{
			JSONObject mainObject=new JSONObject();
			JSONObject option=new JSONObject();
			
			JSONObject title=new JSONObject();
			title.put("text","ECharts 数据是异步获取的");
			option.put("title",title);
			
			JSONObject tooltip=new JSONObject();
			tooltip.put("trigger","axis");
			option.put("tooltip",tooltip);
			
			JSONObject legend=new JSONObject();
			JSONArray legend_data=new JSONArray();
			legend_data.put("销量1");
			legend_data.put("销量2");
			legend.put("data",legend_data);
			option.put("legend",legend);
			
			JSONObject xAxis=new JSONObject();
			JSONArray xAxis_data=new JSONArray();
			xAxis_data.put("1月");
			xAxis_data.put("2月");
			xAxis_data.put("3月");
			xAxis_data.put("4月");
			xAxis_data.put("5月");
			xAxis_data.put("6月");
			xAxis.put("data", xAxis_data);
			option.put("xAxis",xAxis);
			
			JSONObject yAxis=new JSONObject();
			option.put("yAxis",yAxis);
			
			JSONArray dataZoom=new JSONArray();
			JSONObject dataZoom_sub1=new JSONObject();
			dataZoom_sub1.put("type","slider");
			dataZoom_sub1.put("start",0);
			dataZoom_sub1.put("end",50);
			dataZoom.put(dataZoom_sub1);
			JSONObject dataZoom_sub2=new JSONObject();
			dataZoom_sub2.put("type","inside");
			dataZoom_sub2.put("start",0);
			dataZoom_sub2.put("end",50);
			dataZoom.put(dataZoom_sub2);
			option.put("dataZoom",dataZoom);
			
			JSONArray series=new JSONArray();
			JSONObject series_sub1=new JSONObject();
			series_sub1.put("name", "销量1");
			series_sub1.put("type", "line");
			series_sub1.put("smooth", true);
			JSONArray series_sub1_data=new JSONArray();
			series_sub1_data.put(11);
			series_sub1_data.put(21);
			series_sub1_data.put(19);
			series_sub1_data.put(14);
			series_sub1_data.put(10);
			series_sub1_data.put(15);
			series_sub1.put("data", series_sub1_data);
			series.put(series_sub1);
			JSONObject series_sub2=new JSONObject();
			series_sub2.put("name", "销量2");
			series_sub2.put("type", "line");
			series_sub2.put("smooth", true);
			JSONArray series_sub2_data=new JSONArray();
			series_sub2_data.put(8);
			series_sub2_data.put(16);
			series_sub2_data.put(20);
			series_sub2_data.put(18);
			series_sub2_data.put(16);
			series_sub2_data.put(19);
			series_sub2.put("data", series_sub2_data);
			series.put(series_sub2);
			option.put("series",series);
			
			mainObject.put("option",option);
			System.out.println(mainObject.toString());
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
