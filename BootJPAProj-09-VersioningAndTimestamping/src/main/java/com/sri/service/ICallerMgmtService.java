package com.sri.service;

import com.sri.entity.CallerTuneInfo;

public interface ICallerMgmtService {

	String saveCallerTuneInfo(CallerTuneInfo info);
	String updateTuneInfoById(Integer id,String tuneName, String movieName);
	CallerTuneInfo showCallerTuneDetailsById(Integer id);
}
