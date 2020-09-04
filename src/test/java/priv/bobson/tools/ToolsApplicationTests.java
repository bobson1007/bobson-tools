package priv.bobson.tools;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import priv.bobson.tools.controller.AutoPtcgDeckController;

@SpringBootTest
class ToolsApplicationTests {



    @Test
    void contextLoads() {
//        AutoPtcgDeckController.main(new String[]{});
        AutoPtcgDeckController.test4Loop();
    }

}
