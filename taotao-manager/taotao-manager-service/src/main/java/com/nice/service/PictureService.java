package com.nice.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

/**
 * @author ningh
 */
public interface PictureService {
    Map uploadPicture(MultipartFile uploadFile) throws IOException;
}
