import com.hz.testMvc.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springApplication.xml")
public class AccountServiceTest {


//    private IAccountService accountService;
    @Autowired
    private TestService testService;

    @Test
    public void testAdd(){

        String xx = testService.getUserInfo();
        System.out.println("----xx----"+xx);
    }


}
