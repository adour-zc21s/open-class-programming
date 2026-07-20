package com.adour.openclassprog.service.impl;

import com.adour.openclassprog.service.FileStorageService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;
/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 20/07/2026 - 9:13
 */
@Service
public class LocalStorageService implements FileStorageService {
    @Value("${file.upload-dir}")
    private String uploadDir;

    private Path rootLocation;

    @PostConstruct
    public void init() {
        this.rootLocation = Paths.get(uploadDir);
        try {
            Files.createDirectories(this.rootLocation);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage directory", e);
        }
    }

    @Override
    public String saveFile(MultipartFile file) {
        try {
            if (file.isEmpty()) {
                throw new IllegalArgumentException("Failed to store empty file.");
            }

            // 1. Sanitize the filename and grab the extension
            String originalFilename = StringUtils.cleanPath(file.getOriginalFilename());
            String extension = "";
            int i = originalFilename.lastIndexOf('.');
            if (i > 0) {
                extension = originalFilename.substring(i);
            }

            // 2. Generate a unique name to prevent collisions
            String newFilename = UUID.randomUUID().toString() + extension;

            // 3. Resolve the path and force full absolute normalization on BOTH paths
            Path targetLocation = this.rootLocation.toAbsolutePath().normalize();
            Path destinationFile = targetLocation.resolve(Paths.get(newFilename)).normalize();

            // Enhanced Security Check: Verify the destination actually starts with the target directory path
            if (!destinationFile.startsWith(targetLocation)) {
                throw new SecurityException("Cannot store file outside current directory.");
            }

            // 4. Copy the file input stream securely
            Files.copy(file.getInputStream(), destinationFile, StandardCopyOption.REPLACE_EXISTING);

            // Return just the filename or a relative path to store in the DB
            return newFilename;
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file.", e);
        }
    }

    @Override
    public void deleteFile(String filename) {
        try {
            Path file = this.rootLocation.resolve(filename).normalize().toAbsolutePath();
            Files.deleteIfExists(file);
        } catch (IOException e) {
            // Log warning, don't break the application flow if cleanup fails
            System.err.println("Could not delete file: " + filename);
        }
    }
}
