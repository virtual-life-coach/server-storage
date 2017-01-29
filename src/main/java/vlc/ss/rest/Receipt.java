package vlc.ss.rest;

import com.google.api.server.spi.ServiceException;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import vlc.common.to.ReceiptTO;
import vlc.ss.dao.EntityDAO;

/**
 * The Receipt API which Endpoints will be exposing as REST service.
 */
@Api(
        name = "receipt",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "vlc-server-storage",
                ownerName = "vlc-server-storage",
                packagePath = ""
        )
)
public class Receipt {

    /**
     * GET method.
     *
     * @return receipt retrieved
     * @throws ServiceException on malformed requests or back end error
     */
    @ApiMethod(
            name = "getRandom",
            path = "receipt",
            httpMethod = ApiMethod.HttpMethod.GET)
    public ReceiptTO getRandomReceipt() throws ServiceException {
        return EntityDAO.getRandomReceipt();
    }
}
