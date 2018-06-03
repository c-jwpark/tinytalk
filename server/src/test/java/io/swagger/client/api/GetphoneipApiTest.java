package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.model.PhoneIp;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for GetphoneipApi
 */
@Ignore
public class GetphoneipApiTest {

    private final GetphoneipApi api = new GetphoneipApi();

    
    /**
     * Request phoneip for specified phone number
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void phoneipTest() throws ApiException {
        String phonenumber = null;
        PhoneIp response = api.phoneip(phonenumber);

        // TODO: test validations
    }
    
}