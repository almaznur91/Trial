//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import ru.inovus.test.entity.CarNumberEntity;
//import ru.inovus.test.repository.CarNumberRepository;
//import ru.inovus.test.service.CarNumberService;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class CarNumberServiceTest {
//    private CarNumberService service;
//
//
//    @BeforeEach
//    void setUp() {
//        CarNumberRepository repository = null;
//        service = new CarNumberService(repository);
//    }
//
////    @Test
////    void getNextNumberFirst() {
////
////        service.setCarNumber(new CarNumberEntity("А", "А", "Х", 9990));
////        String result = service.nextNumber();
////
////        assertEquals("А000ВА 116 RUS", result);
////    }
//
//    @Test
//    void getNextNumberSecond() {
//
//        service.setCarNumber(new CarNumberEntity("А", "Х", "А", 900));
//        String result = service.nextNumber();
//
//        assertEquals("А901ХА 116 RUS", result);
//    }
//
//    @Test
//    void getNextNumberThird() {
//
//        service.setCarNumber(new CarNumberEntity("С", "В", "А", 999));
//        String result = service.nextNumber();
//
//        assertEquals("С000ВВ 116 RUS", result);
//    }
//
//    @Test
//    void getNextNumberFourth() {
//
//        service.setCarNumber(new CarNumberEntity("Х", "Х", "Х", 999));
//        String result = service.nextNumber();
//
//        assertEquals("А000АА 116 RUS", result);
//    }
//
//    @Test
//    void getNextNumberFifth() {
//
//        service.setCarNumber(new CarNumberEntity("А", "А", "Х", 999));
//        String result = service.nextNumber();
//
//        assertEquals("А000ВА 116 RUS", result);
//    }
//
//    @Test
//    void getNextNumberSixth() {
//
//        service.setCarNumber(new CarNumberEntity("А", "А", "Х", 999));
//        String result = service.nextNumber();
//
//        assertEquals("А000ВА 116 RUS", result);
//    }
//
//    @Test
//    void getNextNumberSeventh() {
//
//        service.setCarNumber(new CarNumberEntity("А", "Х", "А", 999));
//        String result = service.nextNumber();
//
//        assertEquals("А000ХВ 116 RUS", result);
//    }
//
//    @Test
//    void getRandomNumber() {
//
//        String result = service.randomNumber();
//        List<String> results = new ArrayList<>();
//        results.add(result);
//
//        assertEquals(1, results.size());
//    }
//
//}
//
