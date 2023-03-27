package com.gym1.mapper;

import com.gym1.entity.VenueState;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;


@Mapper
public interface VenueStateMapper {

    int addVenueState(VenueState venueState);
    int deleteVenueState(VenueState venueState);
    int editVenueState(VenueState venueState);

    List<VenueState> queryVenueStateByIdDate(int id, String now, String max);



}
