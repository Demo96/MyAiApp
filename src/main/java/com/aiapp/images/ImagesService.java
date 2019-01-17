package com.aiapp.images;

import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImagesService {

	private final Path rootLocation = Paths
			.get("C:\\Users\\Jakub\\Documents\\workspace-spring-tool-suite-4-4.0.1.RELEASE\\MyAiApp\\fe\\aiapp\\src\\assets\\images");

	public void store(MultipartFile file, String prefix) {
		try {
			String fileName=file.getOriginalFilename();
			Files.copy(file.getInputStream(), this.rootLocation.resolve(prefix+fileName), StandardCopyOption.REPLACE_EXISTING);
		} catch (FileAlreadyExistsException e) {
			throw new RuntimeException("Failed to store image: File already exist " + file.getOriginalFilename());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to store image " + file.getOriginalFilename());
		}
	}

	public Resource load(String filename) {
		try {
			filename=filename.substring(0, filename.length()-3) + "." + filename.substring( filename.length()-3,filename.length());
			Path filePath = this.rootLocation.resolve(filename);
			return new UrlResource(filePath.toUri());

		} catch (Exception e) {
			throw new RuntimeException("Failed to load image " + filename);
		}
	}
	public void deleteImage(String filename) {
		filename=filename.substring(0, filename.length()-3) + "." + filename.substring( filename.length()-3,filename.length());
		Path filePath = this.rootLocation.resolve(filename);
		FileSystemUtils.deleteRecursively(filePath.toFile());
	}
}