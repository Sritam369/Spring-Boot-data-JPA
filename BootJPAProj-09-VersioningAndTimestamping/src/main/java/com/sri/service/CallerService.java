package com.sri.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sri.entity.CallerTuneInfo;
import com.sri.repository.CallerTuneRepo;

@Service
public class CallerService implements ICallerMgmtService {

	@Autowired
	private CallerTuneRepo callerTuneRepo;
	
	
    public String saveCallerTuneInfo(CallerTuneInfo info) {
        Integer idVal = callerTuneRepo.save(info).getTuneId();
        return "CallerTune is saved with the id Value::" + idVal;
    }

    
    public String updateTuneInfoById(Integer id, String tuneName, String movieName) {
        Optional<CallerTuneInfo> opt = callerTuneRepo.findById(id);

        if (opt.isPresent()) {
            CallerTuneInfo info = opt.get();
            info.setTuneName(tuneName);
            info.setMovieName(movieName);

            CallerTuneInfo tune = callerTuneRepo.save(info);

            return "Object is updated for " + tune.getUpdatedCount() + 
                   " times ... lastly modified on: " + tune.getLastlyUpdatedOn() +
                   " ... created on: " + tune.getServiceOptedOn();
        } else {
            return "CallerTuneService is not found";
        }
    }

    
    public CallerTuneInfo showCallerTuneDetailsById(Integer id) {
        return callerTuneRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("caller tune not found"));
    }

}
