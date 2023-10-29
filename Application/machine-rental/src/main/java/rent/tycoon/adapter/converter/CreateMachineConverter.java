package rent.tycoon.adapter.converter;

import rent.tycoon.adapter.gateways.mapper.FilesJpaMapper;
import rent.tycoon.adapter.gateways.mapper.ProductJpaMapper;
import rent.tycoon.domain.Files;
import rent.tycoon.domain.IProduct;

import java.util.ArrayList;
import java.util.List;

public class CreateMachineConverter {

    private CreateMachineConverter(){}

    public static ProductJpaMapper toMachineJpaMapper(IProduct iProduct){
        List<FilesJpaMapper> filesJpaMappers = mapFiles(iProduct.getFileUrl());
        return ProductJpaMapper.builder()
                .name(iProduct.getName())
                .description(iProduct.getDescription())
                .status(iProduct.getStatus())
                .price(iProduct.getPrice())
                .files(filesJpaMappers)
                .build();
   }

    private static List<FilesJpaMapper> mapFiles(List<Files> fileUrl) {
        List<FilesJpaMapper> filesJpaMapper = new ArrayList<>();
        if (fileUrl != null) {
            for (Files file : fileUrl) {
                filesJpaMapper.add(createFilesJpaMapper(file.getFileUrl(), file.getType()));
            }
        }
        return filesJpaMapper;
    }

    private static FilesJpaMapper createFilesJpaMapper(String fileUrl, String type) {
        return FilesJpaMapper.builder()
                .fileUrl(fileUrl)
                .type(type)
                .build();
    }
}
