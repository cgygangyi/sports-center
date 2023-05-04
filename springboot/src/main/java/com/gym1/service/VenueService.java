package com.gym1.service;


import com.gym1.entity.Venue;
import com.gym1.mapper.VenueMapper;
import com.gym1.mapper.VenueTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class VenueService {

    @Autowired
    private VenueMapper venueMapper;

    @Autowired
    private VenueTypeMapper venueTypeMapper;


    public List<Venue> getAllVenue(){
        return venueMapper.queryAllVenue();
    }

    public Venue getVenueInfo(int venueId){
        return venueMapper.queryVenueById(venueId);
    }

    public int addVenue(String image, String type, String name, String address, double price){
        List<Venue> venues = venueMapper.queryVenueByName(name);
        if (venues.size() != 0){
            return -2;
        }else{
            int typeId = venueTypeMapper.queryVenueTypeIdByVenueTypeName(type);
            Venue venue = new Venue(typeId, name, address, price, image);
            int res = 0;
            try{
                res = venueMapper.addVenue(venue);
                return res;
            }catch (Exception e){
                return -1;
            }
        }
    }

    public int editVenue(String image, String type, String name,
                         String address, double price, int venueId){
        int typeId = venueTypeMapper.queryVenueTypeIdByVenueTypeName(type);
        int res = 0;
        try{
            res = venueMapper.updateVenueById(image, typeId, name, address, price, venueId);
            return res;
        }catch (Exception e){
            return -1;
        }
    }

    public int deleteVenue(int id){
        int res = 0;
        try{
            res = venueMapper.updateVenueValidById(id);
            return res;
        }catch (Exception e){
            return -1;
        }
    }


}
