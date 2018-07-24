package com.subbu.shareapp.rest;

import java.io.IOException;
import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

import com.subbu.shareapp.service.ShareAppService;
import com.subbu.shareapp.service.ShareAppServiceImpl;
import com.subbu.shareapp.utils.Message;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Singleton
public class ShareAppResource {

	@GET
	@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	public Response test() {
        return Response.ok().build();
	}


	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(String json) {
        JSONObject jsonObj = new JSONObject(json);

		ShareAppService shareAppService = new ShareAppServiceImpl();
		Message msg=new Message();
		int userId = shareAppService.authenticateUser(jsonObj.getString("mobile"),"");
		if (userId != 0){
			msg.setMessage("User Authenticated Sucessfully");
			msg.setCode(1000);
			msg.setUserId(userId);
		}else{
			msg.setMessage("Wrong details provided");
			msg.setCode(2000);
			msg.setUserId(0);
		}
        return Response.ok(msg).build();
	}

	@POST
	@Path("/signup")
	@Produces(MediaType.APPLICATION_JSON)
	public Response signup(@QueryParam("mobile") String mobile,@QueryParam("otp") String otp) {
        return Response.ok().build();
	}

	@POST
	@Path("/expense")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addExpense(String json) {
      
		ShareAppService shareAppService = new ShareAppServiceImpl();
		Message msg = new Message();
		if (shareAppService.addExpense(json)){
			msg.setMessage("Expense Created Sucessfully");
			msg.setCode(1100);
		}else{
			msg.setMessage("Wrong details provided");
			msg.setCode(2100);
		}
        return Response.ok(msg).build();
	}
	@GET
	@Path("/reports")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getReports(@QueryParam("userId") int userId) {
      
		ShareAppService shareAppService = new ShareAppServiceImpl();
		List reports = null;
		ObjectMapper mapperObj = new ObjectMapper();
		String jsonStr = "";
		try {
			reports = shareAppService.reports(userId);
			jsonStr = mapperObj.writeValueAsString(reports);
			
		} catch (JsonGenerationException e) {
		
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
       
        return Response.ok(jsonStr).build();
	}
	
}