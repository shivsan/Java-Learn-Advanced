import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class GenericsTest extends TestCase {

    @Test
    public void shouldAddDifferentSubTypeToSuperTypeList() {
        new Generics().addDifferentSubTypeToSuperTypeList();
    }
}
