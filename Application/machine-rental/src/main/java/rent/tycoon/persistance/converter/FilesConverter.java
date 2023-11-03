package rent.tycoon.persistance.converter;

import rent.tycoon.domain.Files;
import rent.tycoon.persistance.databases.entity.FilesJpaMapper;

import java.util.ArrayList;
import java.util.List;

public class FilesConverter {
    public static List<Files> mapToFiles(List<FilesJpaMapper> fileUrl) {
        List<Files> files = new ArrayList<>();
        if (fileUrl != null) {
            for (FilesJpaMapper file : fileUrl) {
                files.add(createFiles(file.getFileUrl(), file.getType()));
            }
        }
        return files;
    }

    private static Files createFiles(String fileUrl, String type) {
        return Files.builder()
                .fileUrl(fileUrl)
                .type(type)
                .build();
    }

    public static List<FilesJpaMapper> mapToJpaFiles(List <Files> files) {
        List<FilesJpaMapper> jpaFiles = new ArrayList<>();
        if (files != null) {
            for (Files file : files) {
                jpaFiles.add(createJpaFiles(file.getFileUrl(), file.getType()));
            }
        }
        return jpaFiles;
    }

    private static FilesJpaMapper createJpaFiles(String fileUrl, String type) {
        return FilesJpaMapper.builder()
                .fileUrl(fileUrl)
                .type(type)
                .build();
    }

    public static List <FilesJpaMapper> updateFiles(List <FilesJpaMapper> existing){
        List<FilesJpaMapper> newFiles = new ArrayList<>();
        if (existing != null) {
            for (FilesJpaMapper file : existing) {
                newFiles.add(createJpaFiles(file.getFileUrl(), file.getType()));
            }
        }
        return newFiles;
    }
}
