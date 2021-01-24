package com.example.services.s3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.example.model.UploadFileModel;

@Service
public class S3Service {
	
	private AmazonS3 awsS3;
	private String bucket;
	private String region;
	
	@Autowired
	public S3Service(AmazonS3 amazonS3, String awsRegion, String awsBucket) {
		this.awsS3 = amazonS3;
		this.bucket = awsBucket;
		this.region = awsRegion;
	}
	
	public List<UploadFileModel> upload(MultipartFile[] files){
		
		List<UploadFileModel> uploadList = new ArrayList<UploadFileModel>();
		
		for (MultipartFile file : files) {
			String originalName = file.getOriginalFilename();
			String s3FileName = getUniqueName(originalName);
			
			ObjectMetadata metadata = new ObjectMetadata();
			metadata.setContentLength(file.getSize());
			
			try {
				PutObjectRequest request = new PutObjectRequest(originalName, s3FileName, file.getInputStream(), metadata)
						.withCannedAcl(CannedAccessControlList.PublicRead);
				
				awsS3.putObject(request);
				
				String localizacao = getFileLocalizacao(s3FileName);
				
				UploadFileModel uploadModel = new UploadFileModel(s3FileName, localizacao);
				
				uploadList.add(uploadModel);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return uploadList;
	}
	
	private String getFileLocalizacao(String filename) {
		return "https://"+bucket+".s3."+region+".amazonaws.com/"+filename;
	}
	
	private String getUniqueName(String originalName) {
		return UUID.randomUUID().toString()+"_"+originalName;
	}
}
