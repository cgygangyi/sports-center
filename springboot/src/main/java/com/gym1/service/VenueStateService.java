package com.gym1.service;


import com.gym1.entity.VenueState;
import com.gym1.mapper.VenueStateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat temp = new SimpleDateFormat("yyyy-MM-dd");
        calendar.add(Calendar.DATE, 4);
        String max = temp.format(calendar.getTime()) + " 00:00:00";

        List<VenueState> query = venueStateMapper.queryVenueStateByIdDate(id, now, max);
        List<VenueState> query1 = venueStateMapper.queryVenueStateByIdDate2(id, now, max);
        List<VenueState> res = new ArrayList<VenueState>();

        int num = 0;
        Date begin;
        Date end;
        Date valid;
        for (int i = 0; i < 4; i++){
            for (int j = 9; j < 19; j++){
                calendar = Calendar.getInstance();
                calendar.add(Calendar.DATE, i);
                date = calendar.getTime();
                begin = new Date(date.getYear(), date.getMonth(), date.getDay(), j, 0, 0);
                end = new Date(date.getYear(), date.getMonth(), date.getDay(), j+1, 0, 0);
                if (query1.contains(new VenueState(id, begin, end))){
                    res.add(num, query.get(query1.indexOf(new VenueState(id, begin, end))));
                    valid = new Date(date.getYear(), date.getMonth(), date.getDay(),
                            date.getHours()+1, date.getMinutes(), date.getMinutes());
                    if (valid.compareTo(res.get(num).getBegin()) != -1){
                        res.get(num).setOpen(1);
                    }
                }else{
                    res.add(num, new VenueState(id, begin, end, 0, 0));
                }
                num += 1;
            }
        }
        return res;
    }


    public List<VenueState> getAllVenueState(){

        return venueStateMapper.queryAllVenueState();

    }

}
