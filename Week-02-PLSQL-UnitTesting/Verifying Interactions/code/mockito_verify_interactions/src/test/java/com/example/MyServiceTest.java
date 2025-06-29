package com.example;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

class MyServiceTest {

	 @Test
	    public void testVerifyInteraction() {
	        ExternalApi mockApi = mock(ExternalApi.class);     // Step 1
	        MyService service = new MyService(mockApi);        // Step 2
	        service.fetchData();                               // Step 2
	        verify(mockApi).getData("jas");                 // Step 3: Argument verification
	    }
}
