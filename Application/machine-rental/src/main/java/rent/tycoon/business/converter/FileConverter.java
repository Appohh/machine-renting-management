package rent.tycoon.business.converter;

import org.springframework.web.multipart.MultipartFile;
import rent.tycoon.domain.Files;

import java.util.List;
import java.util.stream.Collectors;

public class FileConverter {

    public static List<Files> convertToFileObject(List<MultipartFile> multipartFiles) {
        return multipartFiles.stream()
                .map(file -> Files.builder()
                        .fileUrl(file.getOriginalFilename())
                        .type(file.getContentType())
                        .build())
                .collect(Collectors.toList());
    }
}
