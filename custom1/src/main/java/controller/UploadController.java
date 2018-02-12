package controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	@RequestMapping(value="/upload",method=RequestMethod.GET)
	public String upload(){
		System.out.println("업로드");
		return "upload";
	}
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String uplaodResult(@RequestParam("uploadFile") MultipartFile mf, Model model) throws IllegalStateException, IOException {
		//파일명
		String name = mf.getOriginalFilename();
		//파일크기
		long size = mf.getSize();
		//컨덴츠 타입
		String contentType = mf.getContentType();
		//내용(byte배열)
		byte[] fileContents = mf.getBytes();
		//파일로 저장 transferTo(경로파일명)
		mf.transferTo(new File("/tmp/"+name));
		model.addAttribute("msg","업로드 성공");
		return "uploadOk";
	}
}
