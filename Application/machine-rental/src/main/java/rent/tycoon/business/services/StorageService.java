package rent.tycoon.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import rent.tycoon.adapter.config.FileStorageProperties;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@Service
public class StorageService {
    private final FileStorageProperties fileStorageProperties;

    @Autowired
    public StorageService(FileStorageProperties fileStorageProperties){
        this.fileStorageProperties = fileStorageProperties;
    }

    public void store(MultipartFile file, Long productId) {
        try {
            if (file.isEmpty()) {
                throw new RuntimeException("Failed to store empty file " + file.getOriginalFilename());
            }

            String baseDir = fileStorageProperties.getUploadDir();
            Path productFolder = Paths.get(baseDir, "ProductNumber_" + productId);

            if (!Files.exists(productFolder)) {
                Files.createDirectories(productFolder);
            }

            Files.copy(file.getInputStream(), productFolder.resolve(Objects.requireNonNull(file.getOriginalFilename())));
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file " + file.getOriginalFilename(), e);
        }
    }
}
