package com.sri.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sri.entity.CallerTuneInfo;
import com.sri.service.ICallerMgmtService;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private ICallerMgmtService service;

    @Override
    public void run(String... args) throws Exception {

         try {
            CallerTuneInfo info = new CallerTuneInfo("oo antava mama", "pushpa");
            System.out.println(service.saveCallerTuneInfo(info));
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++"); 

        try {
            System.out.println(service.updateTuneInfoById(1, "joome jo pathan1", "pathan"));
            System.out.println(service.showCallerTuneDetailsById(1));
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");

        try {
            System.out.println(service.updateTuneInfoById(1, "Natu Natu1", "RRR"));
            System.out.println(service.showCallerTuneDetailsById(1));
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}