package Settings;

import java.io.IOException;
import java.util.List;

public interface DeleteProductGatewayInterface {
    boolean deleteProducts(List<String> listIds) throws IOException, ClassNotFoundException;
}
