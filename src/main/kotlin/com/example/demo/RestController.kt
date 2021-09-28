package com.example.demo

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.multipart.MultipartFile

@org.springframework.web.bind.annotation.RestController
class RestController {
    var log: Logger = LoggerFactory.getLogger(RestController::class.java)

    @PostMapping("/users/profile")
    fun handleFileUpload(
        @RequestParam("name") name: String?,
        @RequestParam(name = "file", required = false) file: MultipartFile?
    ): ResponseEntity<*>? {
        log.info(" name : {}", name)
        if (file != null) {
            log.info("image : {}", file.getOriginalFilename())
            log.info("image content type : {}", file.getContentType())
            return ResponseEntity<String>("Uploaded With File", HttpStatus.OK)
        }
        return ResponseEntity<String>("Uploaded", HttpStatus.OK)
    }

    @GetMapping("/hello")
    fun handleHello (): ResponseEntity<*>?{
        return ResponseEntity<String>("Hello", HttpStatus.OK)
    }
}