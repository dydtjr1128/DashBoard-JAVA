

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.ConnectorDTO;
import service.TestSimpleMQTT;


@WebServlet("/DataController/*")
public class DataController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TestSimpleMQTT mqtt;
	
    public DataController() {
    	
        super();
        
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		mqtt=TestSimpleMQTT.getInstance();
	
		
		String url=request.getRequestURI();
		
		//request.setAttribute("model", String.valueOf(connectDevice.getDevices()));
	
		if(url.contains("connector"))
			response.getWriter().append(String.valueOf(mqtt.getDto().getDevices()));
		
		
		if(url.contains("location")) {
			
			System.out.println("location");
			JSONArray jsonArr=new JSONArray(); 
			JSONObject jobj=new JSONObject();
			
		
			/*jobj.put("lat","40.581456");
			jobj.put("lng","128.010085");*/
			
			jobj.put("lat","40");
			jobj.put("lng","128");
			jsonArr.add(jobj);
			System.out.println(jobj);
			String json = jsonArr.toJSONString();
			response.getWriter().print(json);
			
			//response.getWriter().flush();
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
