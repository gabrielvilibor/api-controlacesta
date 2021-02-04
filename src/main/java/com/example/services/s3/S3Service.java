package com.example.services.s3;

import java.io.IOException;
import java.io.InputStream;
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

    private String bucket = "controlacesta-images";
    private String region = "us-east-2";
    private S3Config s3Config;

    @Autowired
    public S3Service(S3Config s3Config, String awsRegion, String awsBucket) {
        this.s3Config = s3Config;
        this.bucket = awsBucket;
        this.region = awsRegion;
    }

    public List<UploadFileModel> upload(MultipartFile[] files) {
        InputStream input = null; // Instancio o objeto InputStream
        List<UploadFileModel> uploadList = new ArrayList<UploadFileModel>();

        for (MultipartFile file : files) {
            try {

                input = file.getInputStream(); // Seto o objeto file no objeto InputStream para que o S3 possa ler esse Stream em byte, e seja reconhecido.
                String fileName = file.getOriginalFilename(); // Obtém o nome do arquivo especificado pelo cliente
                String s3FileName = getUniqueName(fileName); // Utilizo seu método para obter o nome desejado do arquivo no S3

                ObjectMetadata meta = new ObjectMetadata(); // Instancio um novo objeto meta-dados
                meta.setContentType(file.getContentType()); // Seto o típo do conteúdo no objeto meta-dados
                meta.setContentLength(file.getSize()); // Seto o tamanho do conteúdo no objeto meta-dados 

                AmazonS3 s3Client = s3Config.getAmazonS3(); // Busco o objeto s3 com as permissões do IAM

                s3Client.putObject(new PutObjectRequest(bucket, fileName, input, meta) // Adiciona o objeto InputStream ao S3
                        .withCannedAcl(CannedAccessControlList.PublicRead)); // O acesso é público para que o seu front-end possa exibir por meio da URL

                String caminho = getFileLocalizacao(s3FileName); // Crio o caminho do arquivo no S3 para acesso via URL
                caminho = caminho.replaceAll(" ", "+"); // Caso haja espaço o navegador troca por %20, então antecipo trocando " " por "+" para que o navegador identifuqe corretamente no front-end
                
                UploadFileModel uploadModel = new UploadFileModel(s3FileName, caminho); // Crio o objeto uploadModel
                
                uploadList.add(uploadModel); // Adiciono a Lista uploadList

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return uploadList;
    }

    private String getFileLocalizacao(String filename) {
        return "https://" + bucket + ".s3." + region + ".amazonaws.com/" + filename;
    }

    private String getUniqueName(String originalName) {
        return UUID.randomUUID().toString() + "_" + originalName;
    }
}