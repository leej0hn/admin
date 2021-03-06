package com.redscarf.admin.web.controller;

import com.redscarf.admin.common.exception.ServiceException;
import com.redscarf.admin.common.vo.Response;
import com.redscarf.admin.service.TestService;
import com.redscarf.admin.web.configuration.WebConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * <p>function:
 * <p>User: LeeJohn
 * <p>Date: 2017/01/11
 * <p>Version: 1.0
 */
@Slf4j
@RestController
public class TestController {
    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private TestService testService;

    @Value("${web.ips:}")
    private String ips;

    @Autowired
    private WebConfig config;

    @RequestMapping(value = "/api/test", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response index() {
        return Response.ok("test");
    }

    @GetMapping("/page/test")
    public ModelAndView testPage() {
        String test = "Test Page , hello world ";
        return new ModelAndView("testPage","test",test);
    }

    @GetMapping("/api/exception")
    public Response testExcption(){
        throw new ServiceException("testException msg");
    }

    @PostMapping("/api/file/upload")
    public Response<String> fileUpload(@RequestParam("uploadFile") MultipartFile uploadFile) throws Exception{
        if (uploadFile.isEmpty()) {
            throw new ServiceException("uploadFile is null");
        }
        String fileName = uploadFile.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String imageName = UUID.randomUUID().toString() + suffixName;
        Files.copy(uploadFile.getInputStream(), Paths.get(config.getFileUploadPath(), imageName));
        return Response.ok(imageName);
    }

    @GetMapping("/api/file/download/{id:.+}")
    @ResponseBody
    public ResponseEntity<?> fileDownload(@PathVariable String id) {
        return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(config.getFileUploadPath(), id).toString()));
    }
}
