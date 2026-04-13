package com.sri.runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sri.entity.MarriageSeeker;
import com.sri.service.IMatrimonyServiceMgmt;

@Component
public class Runner implements CommandLineRunner {

	@Autowired
	private IMatrimonyServiceMgmt service;
	@Override
	public void run(String... args) throws Exception {
		String name = IO.readln("enter name");
		String addr = IO.readln("enter address");
		String photoPath = IO.readln("enter person photo file complete path");
		String bioDataPath = IO.readln("enter person bio data file complete path");
		boolean indian = Boolean.parseBoolean(IO.readln("is this person indian ? "));
		
		InputStream is =new FileInputStream(photoPath);
		byte[] photoData = new byte[is.available()];
		photoData = is.readAllBytes();
		
		File file = new File(bioDataPath);
		Reader reader = new FileReader(file);
		char bioDataContent[] = new char[(int) file.length()];
		reader.read(bioDataContent);
		
		MarriageSeeker seeker = new MarriageSeeker(name,addr,photoData,LocalDateTime.of(1990, 11,23,12,45),bioDataContent,indian);
		IO.println(service.registerMarriageSeeker(seeker));
		
		Optional<MarriageSeeker> opt = service.searchSeekerById(100l);
		if(opt.isPresent()) {
			MarriageSeeker s = opt.get();
			IO.println(s.getId()+" "+s.getName()+" "+s.getAddrs()+" "+s.isIndian());
			
			OutputStream os = new FileOutputStream("retrieve_photo.giff");
			os.write(s.getPhoto());
			os.flush();
			Writer writer = new FileWriter("retrieve_biodata.txt");
			writer.write(s.getBiodata());
			writer.flush();
			os.close();
			writer.close();
			IO.println("LOBs are retrieved");
		}
		else {
			IO.println("Records not found");
		}
	}

}
