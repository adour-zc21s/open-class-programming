package com.adour.openclassprog.service;

import org.springframework.web.multipart.MultipartFile;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 20/07/2026 - 9:00
 */
public interface FileStorageService {
    String saveFile(MultipartFile file);
    void deleteFile(String filePath);
}
