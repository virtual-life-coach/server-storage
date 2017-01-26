package com.example.echo;

import com.google.api.server.spi.auth.common.User;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.config.Nullable;
import com.google.api.server.spi.response.NotFoundException;
import com.google.api.server.spi.response.UnauthorizedException;

import java.util.ArrayList;
import java.util.List;

/**
 * The Echo API which Endpoints will be exposing.
 */
@Api(
        name = "echo",
        version = "v1",
        namespace =
        @ApiNamespace(
                ownerDomain = "echo.example.com",
                ownerName = "echo.example.com",
                packagePath = ""
        )/*,
        // [START_EXCLUDE]
        issuers = {
                @ApiIssuer(
                        name = "firebase",
                        issuer = "https://securetoken.google.com/YOUR-PROJECT-ID",
                        jwksUri = "https://www.googleapis.com/robot/v1/metadata/x509/securetoken@system.gserviceaccount.com")
        }*/
)
public class Echo {
    /**
     * Echoes the received message back. If n is a non-negative integer, the message is copied that
     * many times in the returned message.
     * <p>
     * Note that name is specified and will override the default name of "{class name}.{method
     * name}". For example, the default is "echo.echo".
     * <p>
     * Note that httpMethod is not specified. This will default to a reasonable HTTP method
     * depending on the API method name. In this case, the HTTP method will default to POST.
     */
    @ApiMethod(name = "echo")
    public Message echo(Message message, @Named("n") @Nullable Integer n) {
        return doEcho(message, n);
    }

    /**
     * Echoes the received message back. If n is a non-negative integer, the message is copied that
     * many times in the returned message.
     * <p>
     * Note that name is specified and will override the default name of "{class name}.{method
     * name}". For example, the default is "echo.echo".
     * <p>
     * Note that httpMethod is not specified. This will default to a reasonable HTTP method
     * depending on the API method name. In this case, the HTTP method will default to POST.
     */
    @ApiMethod(name = "echo_path_parameter", path = "echo/{n}")
    public Message echoPathParameter(Message message, @Named("n") int n) {
        return doEcho(message, n);
    }

    /**
     * Echoes the received message back. If n is a non-negative integer, the message is copied that
     * many times in the returned message.
     * <p>
     * Note that name is specified and will override the default name of "{class name}.{method
     * name}". For example, the default is "echo.echo".
     * <p>
     * Note that httpMethod is not specified. This will default to a reasonable HTTP method
     * depending on the API method name. In this case, the HTTP method will default to POST.
     */
    @ApiMethod(name = "echo_api_key", path = "echo_api_key")
    public Message echoApiKey(Message message, @Named("n") @Nullable Integer n) {
        return doEcho(message, n);
    }

    private Message doEcho(Message message, Integer n) {
        if (n != null && n >= 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (i > 0) {
                    sb.append(" ");
                }
                sb.append(message.getMessage());
            }
            message.setMessage(sb.toString());
        }
        return message;
    }

    /**
     * Gets the authenticated user's email. If the user is not authenticated, this will return an HTTP
     * 401.
     * <p>
     * Note that name is not specified. This will default to "{class name}.{method name}". For
     * example, the default is "echo.getUserEmail".
     * <p>
     * Note that httpMethod is not required here. Without httpMethod, this will default to GET due
     * to the API method name. httpMethod is added here for example purposes.
     */
    @ApiMethod(
            httpMethod = ApiMethod.HttpMethod.GET
    )
    public Email getUserEmail(User user) throws UnauthorizedException {
        if (user == null) {
            throw new UnauthorizedException("Invalid credentials");
        }

        Email response = new Email();
        response.setEmail(user.getEmail());
        return response;
    }

    /**
     * Gets the authenticated user's email. If the user is not authenticated, this will return an HTTP
     * 401.
     * <p>
     * Note that name is not specified. This will default to "{class name}.{method name}". For
     * example, the default is "echo.getUserEmail".
     * <p>
     * Note that httpMethod is not required here. Without httpMethod, this will default to GET due
     * to the API method name. httpMethod is added here for example purposes.
     */
    /*
    @ApiMethod(
            path = "firebase_user",
            httpMethod = ApiMethod.HttpMethod.GET
    )
    public Email getUserEmailFirebase(User user) throws UnauthorizedException {
        if (user == null) {
            throw new UnauthorizedException("Invalid credentials");
        }

        Email response = new Email();
        response.setEmail(user.getEmail());
        return response;
    }*/


    @ApiMethod(
            name = "testMethod",
            path = "bar/testMethod",
            httpMethod = ApiMethod.HttpMethod.GET)
    public Email testMethod() {
        Email response = new Email();
        response.setEmail("hey");
        return response;
    }

    @ApiMethod(
            //name = "testMethodBis",
            path = "bar/testMethodBis",
            httpMethod = ApiMethod.HttpMethod.POST)
    public Email testMethodBis(Message mandatory, @Named("n") @Nullable Integer optional) {
        Email response = new Email();
        response.setEmail("mandatory: " + mandatory + ", optional: " + optional);
        return response;
    }

    @ApiMethod(
            //name = "testMethodBis",
            path = "notFound",
            httpMethod = ApiMethod.HttpMethod.GET)
    public Email notFound() throws NotFoundException{
        throw new NotFoundException("TEST");
    }

    @ApiMethod(
            name = "peppino",
            path = "list",
            httpMethod = ApiMethod.HttpMethod.GET)
    public List<Email> list() throws NotFoundException{
        Email a = new Email(), b = new Email();
        a.setEmail("a email");
        b.setEmail("b email");
        ArrayList<Email> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        return list;
    }

    @ApiMethod(
            name = "getById",
            path = "get/{id}",
            httpMethod = ApiMethod.HttpMethod.GET)
    public Message getViaId(@Named("id") String id) {
        Message m = new Message();
        m.setMessage("m " + id);
        return m;
    }

}
