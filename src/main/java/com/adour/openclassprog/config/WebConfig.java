package com.adour.openclassprog.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.nio.file.Paths;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 20/07/2026 - 9:16
 */
@Configuration
public class WebConfig implements WebMvcConfigurer{
    @Value("${file.upload-dir}")
    private String uploadDir;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        String absolutePath = Paths.get(uploadDir).toAbsolutePath().toUri().toString();
        // Ensure the path string ends with a trailing slash and uses 'file:' prefix directly
        String location = uploadDir.endsWith("/") ? "file:" + uploadDir : "file:" + uploadDir + "/";
        // This maps: http://localhost:8081/uploads/profile-pictures/your-uuid.jpg
        registry.addResourceHandler("/uploads/profile-pictures/**")
                .addResourceLocations(location);
    }
}
