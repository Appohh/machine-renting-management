package rent.tycoon.business.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import rent.tycoon.business.exeption.ProductCustomException;
import rent.tycoon.business.interfaces.repo_interfaces.IProductRepo;
import rent.tycoon.business.model.request.machine.CreateMachineRequestModel;
import rent.tycoon.business.model.request.product.CreateProductRequestModel;
import rent.tycoon.business.model.response.CreateProductResponseModel;
import rent.tycoon.domain.IProduct;
import rent.tycoon.domain.factory.IProductFactory;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
@Disabled
class ProductServiceTest {
//    private ProductService productService;
//    private IProductRepo repo;
//    private IProductFactory factory;
//
//
//    @BeforeEach
//    public void setUp() {
//        repo = Mockito.mock(IProductRepo.class);
//        StorageService storageService = Mockito.mock(StorageService.class);
//        factory = Mockito.mock(IProductFactory.class);
//        productService = new ProductService(factory, repo, storageService);
//
//        IProduct mockProduct = Mockito.mock(IProduct.class);
//        Mockito.when(factory.createMachine(Mockito.anyLong(), Mockito.anyString(), Mockito.anyString(), Mockito.anyInt(), Mockito.any(BigDecimal.class), Mockito.anyList(), Mockito.anyString(), Mockito.anyString())).thenReturn(mockProduct);
//        Mockito.when(factory.createAccessory(Mockito.anyLong(), Mockito.anyString(), Mockito.anyString(), Mockito.anyInt(), Mockito.any(BigDecimal.class), Mockito.anyList(), Mockito.anyString(), Mockito.anyString())).thenReturn(mockProduct);
//
//        Mockito.doNothing().when(storageService).store(Mockito.any(MultipartFile.class), Mockito.anyLong());
//    }
//
//    @Test
//    void testCreateMachineSuccess() throws ProductCustomException {
//        // Arrange
//        MultipartFile sampleFile = createSampleMultipartFile();
//
//        List <MultipartFile> fileList = new ArrayList<>();
//        fileList.add(sampleFile);
//
//        CreateProductRequestModel requestModel = new CreateMachineRequestModel("Sample name", "Sample description", 0, new BigDecimal(6000), fileList, "machine", "Sample specific field");
//        long expectedResult = 1L;
//        Mockito.when(repo.save(Mockito.any(IProduct.class))).thenReturn(expectedResult);
//        //Act
//        CreateProductResponseModel responseModel = productService.create(requestModel);
//        //Assert
//        Mockito.verify(repo).save(Mockito.any(IProduct.class));
//        assertEquals(expectedResult, responseModel.getId());
//    }
//
//    @Test
//    void testCreateProductWithNameAlreadyExists() {
//        // Arrange
//        MultipartFile sampleFile = createSampleMultipartFile();
//        List <MultipartFile> fileList = new ArrayList<>();
//        fileList.add(sampleFile);
//        CreateProductRequestModel requestModel = new CreateMachineRequestModel("Sample name", "Sample description", 0, new BigDecimal(6000), fileList, "machine", "Sample specific field");
//        //Act
//        Mockito.when(repo.existsByName(requestModel.getName())).thenReturn(true);
//        //Assert
//        assertThrows(ProductCustomException.class, () -> productService.create(requestModel));
//    }
//
//    @Test
//    void testCreateProductWithInvalidType() {
//        // Arrange
//        MultipartFile sampleFile = createSampleMultipartFile();
//        List <MultipartFile> fileList = new ArrayList<>();
//        fileList.add(sampleFile);
//        CreateProductRequestModel requestModel = new CreateProductRequestModel("Sample name", "Sample description", 0, new BigDecimal(6000), fileList, "invalidType");
//        //Assert
//        assertThrows(ProductCustomException.class, () -> productService.create(requestModel));
//    }
//
//    @Test
//    void testCreateProductSaveFails() {
//        // Arrange
//        MultipartFile sampleFile = createSampleMultipartFile();
//        List <MultipartFile> fileList = new ArrayList<>();
//        fileList.add(sampleFile);
//        CreateProductRequestModel requestModel = new CreateMachineRequestModel("Sample name", "Sample description", 0, new BigDecimal(6000), fileList, "machine", "Sample specific field");
//        IProduct mockProduct = Mockito.mock(IProduct.class);
//        //Act
//        Mockito.when(factory.createMachine(Mockito.anyLong(), Mockito.anyString(), Mockito.anyString(), Mockito.anyInt(), Mockito.any(BigDecimal.class), Mockito.anyList(), Mockito.anyString(), Mockito.anyString())).thenReturn(mockProduct);
//
//        Mockito.when(repo.save(mockProduct)).thenReturn(0L);
//        //Assert
//        assertThrows(ProductCustomException.class, () -> productService.create(requestModel));
//    }
//
//
//    private MultipartFile createSampleMultipartFile() {
//        return new MockMultipartFile("file", "sample-image.jpg", "image/jpeg", "Sample Image Content".getBytes());
//    }
}
