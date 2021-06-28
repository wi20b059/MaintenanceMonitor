import at.maintenanceMonitor.MonitorController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MonitorControllerTest {
    // RESET TEST (PUT)
    @Test
    public void test_reset() {
        //Arrange
        MonitorController.message = "message";

        //Act
        MonitorController.resetMessage();
        String result = MonitorController.message;

        //Assert
        Assertions.assertEquals(MonitorController.INITIAL_MESSAGE, result);
    }

    // POST TEST
    @Test
    public void test_postNullMessage() {
        //Arrange
        String message = null;
        String expectedMessage = MonitorController.message;

        //Act
        MonitorController.postMessage(message);
        String actualMessage = MonitorController.message;

        //Assert
        Assertions.assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void test_postBlankMessage() {
        //Arrange
        String message = "        ";
        String expectedMessage = MonitorController.message;

        //Act
        MonitorController.postMessage(message);
        String actualMessage = MonitorController.message;

        //Assert
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void test_postValidMessage() {
        //Arrange
        String message = "new Message";

        //Act
        MonitorController.postMessage(message);
        String actualMessage = MonitorController.message;

        //Assert
        Assertions.assertEquals(message, actualMessage);
    }

    //GET TEST
    @Test
    public void test_getMessage() {
        //Arrange
        String expectedMessage = "new Message";
        MonitorController.message = expectedMessage;

        //Act
        String actualMessage = (String) MonitorController.getMessage().getEntity();

        //Assert
        Assertions.assertEquals(expectedMessage, actualMessage);
    }
}
