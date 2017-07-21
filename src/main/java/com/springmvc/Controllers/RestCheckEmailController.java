package com.springmvc.Controllers;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.springmvc.model.TestUser;
import com.springmvc.services.TestUserService;
import com.springmvc.services.UserService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestCheckEmailController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/checkEmail", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Boolean postEmail(@RequestBody  String json){
        Boolean isUnique = true;
        JsonParser parser = new JsonParser();
        JsonObject mainObject = parser.parse(json).getAsJsonObject();
        JsonElement email = mainObject.get("email");
        TestUser user = new TestUser();
        user.setEmail(email.getAsString());
        if(user.getEmail()!=null){
            if(userService.findBySSO(user.getEmail())!=null){
                isUnique = false;
            }
        }
        return isUnique;
    }
}
