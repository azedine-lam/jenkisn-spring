package com.securiteS.box.commons;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.WriteChannel;
import com.google.cloud.firestore.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileStore {
	
	FireBaseConfiguration fapp;
	

	@Autowired
	public FileStore(FireBaseConfiguration fapp) {
		this.fapp =fapp;
	}

	
	public void save(String fileName,InputStream inputStream) throws IOException {
		 
		/* InputStream testFile = new FileInputStream(new File(path));
         System.out.println("Buckets:");
         Storage storage = StorageOptions.newBuilder().setCredentials(fapp.fireApp()).build().getService();
         BlobInfo blobInfo = BlobInfo.newBuilder(fapp.buckName, fileName).setContentType("image/jpeg").build();
     	try (WriteChannel writer = storage.writer(blobInfo)) {
			byte[] buffer = new byte[1024];
			int limit;
			try {
				while ((limit = testFile.read(buffer)) >= 0) {
					writer.write(ByteBuffer.wrap(buffer, 0, limit));
				}

			} catch (Exception ex) {
				// handle exception
			}finally {
				writer.close();
			}
		}*/
		byte[] bytes = IOUtils.toByteArray(inputStream);
		    Storage storage = StorageOptions.newBuilder().setCredentials(fapp.fireApp()).build().getService();
		    //InputStream content = new FileInputStream(new File(path));
		    BlobId blobId = BlobId.of(fapp.buckName, fileName);
		    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("image/jpeg").build();
		    storage.create(blobInfo,bytes);
	 }
	
	
}
