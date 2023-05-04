package com.gym1.controller;


import com.gym1.entity.Venue;
import com.gym1.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin
@RequestMapping("/venue")
public class VenueController {

    @Autowired
    private VenueService venueService;


    @GetMapping("/getVenueInfo/{venueId}")
    public Map<String, Object> getVenueInfo(@PathVariable int venueId){
        Map<String, Object> reMap = new HashMap<>();
        Venue res = venueService.getVenueInfo(venueId);
        reMap.put("code", 8001);
        reMap.put("msg", "Success!");
        reMap.put("data", res);
        return reMap;
    }


    @GetMapping("/getAll")
    public Map<String, Object> getAll(){
        Map<String, Object> reMap = new HashMap<>();
        List<Venue> res = venueService.getAllVenue();
        if (res.size() == 0){
            reMap.put("code", 8002);
            reMap.put("msg", "There are no venues!");
            reMap.put("data", res);
        }else{
            reMap.put("code", 8003);
            reMap.put("msg", "Success!");
            reMap.put("data", res);
        }
        return reMap;
    }


    @PostMapping("/addVenue")
    public Map<String, Object> addVenue(@RequestParam("image") MultipartFile image,
                                       @RequestParam("type") String type,
                                       @RequestParam("name") String name,
                                       @RequestParam("address") String address,
                                       @RequestParam("price") double price) throws IOException {
        Map<String, Object> reMap = new HashMap<>();
        BASE64Encoder encoder = new BASE64Encoder();
        String baseStr= encoder.encode(image.getBytes());
        baseStr = baseStr.replaceAll("\r\n", "");
        int res = venueService.addVenue(baseStr, type, name, address, price);
        if (res == -2){
            reMap.put("code", 8004);
            reMap.put("msg", "The item has existed!");
            reMap.put("data", res);
        }else if(res == -1){
            reMap.put("code", 8005);
            reMap.put("msg", "Error!");
            reMap.put("data", res);
        }else if(res == 0){
            reMap.put("code", 8006);
            reMap.put("msg", "Failure!");
            reMap.put("data", res);
        }else{
            reMap.put("code", 8007);
            reMap.put("msg", "Success!");
            reMap.put("data", res);
        }
        return reMap;
    }


    @PostMapping("/editVenue/{venueId}")
    public Map<String, Object> editItem(@RequestParam("image") MultipartFile image,
                                        @RequestParam("type") String type,
                                        @RequestParam("name") String name,
                                        @RequestParam("address") String address,
                                        @RequestParam("price") double price,
                                        @PathVariable int venueId) throws IOException{
        Map<String, Object> reMap = new HashMap<>();
        BASE64Encoder encoder = new BASE64Encoder();
        String baseStr= encoder.encode(image.getBytes());
        baseStr = baseStr.replaceAll("\r\n", "");
        int res = venueService.editVenue(baseStr, type, name, address, price, venueId);
        if (res == -1){
            reMap.put("code", 8008);
            reMap.put("msg", "Error!");
            reMap.put("data", res);
        }else if(res == 0){
            reMap.put("code", 8009);
            reMap.put("msg", "Failure!");
            reMap.put("data", res);
        }else{
            reMap.put("code", 8010);
            reMap.put("msg", "Success!");
            reMap.put("data", res);
        }
        return reMap;
    }


    @PostMapping("/deleteVenue/{venueId}")
    public Map<String, Object> deleteItem(@PathVariable int venueId){
        Map<String, Object> reMap = new HashMap<>();
        int res = venueService.deleteVenue(venueId);
        if (res == -1){
            reMap.put("code", 8011);
            reMap.put("msg", "Error!");
            reMap.put("data", res);
        }else if(res == 0){
            reMap.put("code", 8012);
            reMap.put("msg", "Failure!");
            reMap.put("data", res);
        }else{
            reMap.put("code", 8013);
            reMap.put("msg", "Success!");
            reMap.put("data", res);
        }
        return reMap;
    }

}
