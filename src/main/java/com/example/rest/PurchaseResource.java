package com.example.rest;

import com.example.controllers.business.PurchaseService;
import com.example.orm.entities.Items;
import com.example.orm.entities.Purchase;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;
import java.util.ArrayList;
import java.util.List;

@Path("/purchase-service/")
@Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN})
@Provider
@Service
public class PurchaseResource {

    @Autowired
    private PurchaseService purchaseService;

    @POST
    @Path("/purchase")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({MediaType.APPLICATION_JSON})
    public Boolean doPurchase(String itemsJsonString) throws JSONException {
        if(itemsJsonString != null){
            JSONObject jsonObject = new JSONObject(itemsJsonString);
            if(jsonObject != null){
                JSONArray jsonArray = jsonObject.getJSONArray("items");
                if(jsonArray != null){
                    List<Integer> ids = new ArrayList<Integer>();
                    for(int i=0; i<jsonArray.length(); i++){
                        Object act = jsonArray.get(i);
                        ids.add((Integer)act);
                    }
                    purchaseService.purchase(ids);
                    return true;
                }
            }
        }else{
            System.out.println("Items null");
        }
        return false;
    }

    @GET
    @Path("/purchase")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Purchase> getAll(){
        return purchaseService.getAll();
    }

}
