package com.example.todolist.rest;

import com.example.todolist.model.Attachment;
import com.example.todolist.model.Comment;
import com.example.todolist.service.AttachmentService;
import com.example.todolist.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "Attachment", produces = MediaType.APPLICATION_JSON_VALUE)
public class AttachmentRestController {
    @Autowired
    AttachmentService attachmentService;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping(params = "{id}")
    ResponseEntity<Attachment> getAttachment(@RequestParam("id") Attachment attachment)
    {
        return new ResponseEntity<>(attachment, HttpStatus.OK);
    }

    @DeleteMapping(params = "{id}")
    ResponseEntity<String> deleteAttachment(@RequestParam("id") Long id)
    {
        this.attachmentService.deleteAttachment(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

    @PostMapping(value = "{attachment},{commentId}", consumes =  MediaType.MULTIPART_FORM_DATA_VALUE)
    @Transactional
    ResponseEntity<String> addAttachment(@RequestParam("commentId") Comment comment,
                                         @RequestParam("attachment") MultipartFile file )
    {
        Attachment attachment = new Attachment();
        try {
            File fileDir= new File(uploadPath);
            if (!fileDir.exists()) fileDir.mkdir();
            String uuidfile= UUID.randomUUID().toString();
            String resultFileName = uploadPath + uuidfile + file.getOriginalFilename();
            attachment.setAttachment_link(resultFileName);
            attachment.setAttachment_name(file.getOriginalFilename());
            attachment.setAttachment_type(file.getName());
            attachment.setComment_id(comment);
            file.transferTo(new File(resultFileName));
            InputStream inStr = file.getInputStream();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        finally {
            attachment.setAttachment_date(new Timestamp(System.currentTimeMillis()));
            this.attachmentService.addAttachment(attachment);
        }
        return new ResponseEntity<>("Success", HttpStatus.ACCEPTED);
    }
}
