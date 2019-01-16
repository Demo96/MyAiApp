package com.aiapp.images;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RequestMapping("/images")
@Controller
public class ImagesController {
	@Autowired
    private ImagesService imagesService;
 

    @GetMapping("/{fileName}")
    @ResponseBody
    public ResponseEntity<Resource> saveFile(@PathVariable String fileName) {
        Resource file = imagesService.load(fileName);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
	
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/{id}")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file, @PathVariable int id) {
    	imagesService.store(file, id);
        return ResponseEntity.status(HttpStatus.OK).body("You successfully uploaded " + file.getOriginalFilename() + "!");
    }
    
    @PreAuthorize("isAuthenticated()")
    @DeleteMapping("/{fileName}")
    public ResponseEntity<String> deleteFile(@PathVariable String fileName) {
    	imagesService.deleteImage(fileName);
        return ResponseEntity.status(HttpStatus.OK).body("You successfully deleted "+ fileName + "!");

    }
}