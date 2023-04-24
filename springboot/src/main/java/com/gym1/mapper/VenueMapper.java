package com.gym1.mapper;

import com.gym1.entity.Venue;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VenueMapper {

    int addVenue(Venue venue);
    int deleteVenue(Venue venue);
    int editVenue(Venue venue);

    List<Venue> queryAllVenue();
    Venue queryVenueById(int venueId);
    List<Venue> queryVenueByName(String name);
    List<Venue> queryVenueByNameType(String type, String name);



}
