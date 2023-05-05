package com.gym1.service;


import com.gym1.entity.Venue;
import com.gym1.entity.VenueState;
import com.gym1.mapper.VenueMapper;
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

    @Autowired
    private VenueMapper venueMapper;


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
        Calendar calendar1 = Calendar.getInstance();

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
                    calendar1 = Calendar.getInstance();
                    calendar1.add(Calendar.HOUR, 1);
                    valid = calendar1.getTime();
                    if (valid.compareTo(res.get(num).getBegin()) != -1){
                        res.get(num).setOpen(0);
                    }
                }else{
                    res.add(num, new VenueState(id, begin, end, 0, 0));
                }
                num += 1;
            }
        }
        return res;
    }


    public List<VenueState> getAll(int num){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, num);
        Date date = calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        Date date1 = calendar.getTime();

        Date begin = new Date(date.getYear(), date.getMonth(), date.getDay(), 0, 0, 0);
        Date end = new Date(date1.getYear(), date1.getMonth(), date1.getDay(), 0, 0, 0);
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");

        List<VenueState> venueStates = venueStateMapper.
                queryVenueStateByDate(formatter.format(begin).substring(0,11) + "00:00:00",
                        formatter.format(end).substring(0,11) + "00:00:00");
        List<VenueState> venueStates2 = venueStateMapper.
                queryVenueStateByDate2(formatter.format(begin).substring(0,11) + "00:00:00",
                        formatter.format(end).substring(0,11) + "00:00:00");
        List<Venue> venues = venueMapper.queryAllVenue();
        List<VenueState> res = new ArrayList<VenueState>();

        Calendar calendar2 = Calendar.getInstance();
        Date now = calendar2.getTime();
        Date date2;
        Date date3;
        int number = 0;
        for (Venue venue: venues){
            for (int i = 9; i < 19; i++){
                date2 = new Date(date.getYear(), date.getMonth(), date.getDay(), i, 0, 0);
                date3 = new Date(date.getYear(), date.getMonth(), date.getDay(), i+1, 0, 0);
                if (venueStates2.contains(new VenueState(venue.getId(), date2, date3))){
                    int temp = venueStates2.indexOf(new VenueState(venue.getId(), date2, date3));
                    if (now.compareTo(venueStates.get(temp).getEnd()) == 1){
                        venueStates.get(temp).setFree(1);
                    }
                    res.add(number, venueStates.get(temp));
                }else{
                    res.add(number, new VenueState(venue.getId(), date2, date3, 0, 0));
                }
                number += 1;
            }
        }
        return res;
    }


    public int openVenueState(String list, int num){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, num);
        Date date = calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        Date date1 = calendar.getTime();
        String [] number = list.split(" ");

        Date begin = new Date(date.getYear(), date.getMonth(), date.getDay(), 0, 0, 0);
        Date end = new Date(date1.getYear(), date1.getMonth(), date1.getDay(), 0, 0, 0);
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");

        List<VenueState> venueStates = venueStateMapper.
                queryVenueStateByDate(formatter.format(begin).substring(0,11) + "00:00:00",
                        formatter.format(end).substring(0,11) + "00:00:00");
        List<VenueState> venueStates2 = venueStateMapper.
                queryVenueStateByDate2(formatter.format(begin).substring(0,11) + "00:00:00",
                        formatter.format(end).substring(0,11) + "00:00:00");
        List<Venue> venues = venueMapper.queryAllVenue();

        Date date2;
        Date date3;
        int res = 1;
        for (String string : number){
            int position = Integer.parseInt(string);
            int venueId = venues.get((position-position%10)/10).getId();
            date2 = new Date(date.getYear(), date.getMonth(), date.getDay(), (position%10)+8, 0, 0);
            date3 = new Date(date.getYear(), date.getMonth(), date.getDay(), (position%10)+9, 0, 0);
            if (venueStates2.contains(new VenueState(venueId, date2, date3))){
                int temp = venueStates2.indexOf(new VenueState(venueId, date2, date3));
                int venueStateId = venueStates.get(temp).getId();
                try{
                    res = venueStateMapper.updateVenueStateOpen(venueStateId, 1);
                    if (res == 0){
                        return 0;
                    }
                }catch (Exception e){
                    return -1;
                }
            }else{
                try{
                    res = venueStateMapper.addVenueState(new VenueState(venueId, date2, date3, 1, 1));
                    if (res == 0){
                        return 0;
                    }
                }catch (Exception e){
                    return -1;
                }
            }
        }
        return 1;
    }


    public int closeVenueState(String list, int num){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, num);
        Date date = calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        Date date1 = calendar.getTime();
        String [] number = list.split(" ");

        Date begin = new Date(date.getYear(), date.getMonth(), date.getDay(), 0, 0, 0);
        Date end = new Date(date1.getYear(), date1.getMonth(), date1.getDay(), 0, 0, 0);
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");

        List<VenueState> venueStates = venueStateMapper.
                queryVenueStateByDate(formatter.format(begin).substring(0,11) + "00:00:00",
                        formatter.format(end).substring(0,11) + "00:00:00");
        List<VenueState> venueStates2 = venueStateMapper.
                queryVenueStateByDate2(formatter.format(begin).substring(0,11) + "00:00:00",
                        formatter.format(end).substring(0,11) + "00:00:00");
        List<Venue> venues = venueMapper.queryAllVenue();

        Date date2;
        Date date3;
        int res = 1;
        for (String string : number) {
            int position = Integer.parseInt(string);
            int venueId = venues.get((position - position % 10) / 10).getId();
            date2 = new Date(date.getYear(), date.getMonth(), date.getDay(), (position%10)+8, 0, 0);
            date3 = new Date(date.getYear(), date.getMonth(), date.getDay(), (position%10)+9, 0, 0);
            int temp = venueStates2.indexOf(new VenueState(venueId, date2, date3));
            int venueStateId = venueStates.get(temp).getId();
            try{
                res = venueStateMapper.updateVenueStateOpen(venueStateId, 0);
                if (res == 0){
                    return 0;
                }
            }catch (Exception e){
                return -1;
            }
        }
        return 1;
    }


}
