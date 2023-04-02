package com.gym1.service;
import com.gym1.entity.Venue;
import com.gym1.entity.VenueState;
import com.gym1.mapper.VenueMapper;
import com.gym1.mapper.VenueStateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Service
public class VenueStateService {

    @Autowired
    private VenueStateMapper venueStateMapper;

    public List<VenueState> getPotentialState(int id){

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        String a = formatter.format(date);
        String now = a.substring(0,11) + "00:00:00";

        System.out.println(now);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat temp = new SimpleDateFormat("yyyy-MM-dd");
        calendar.add(Calendar.DATE, 4);
        String max = temp.format(calendar.getTime()) + " 00:00:00";
        System.out.println(max);


        return venueStateMapper.queryVenueStateByIdDate(id, now, max);

    }
    public List<VenueState> getAllVenueState(){

        return venueStateMapper.queryAllVenueState();

    }

}
