package net.trajano.test.web.test;

import java.util.Arrays;
import java.util.UUID;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.wso2.carbon.core.services.echo.Echo;
import org.wso2.carbon.core.services.echo.EchoPortType;
import org.wso2.carbon.core.services.echo.xsd.SimpleBean;

public class TestWs {
	@Before
	public void setup() {
		echoPort = new Echo().getEchoHttpSoap11Endpoint();
		((BindingProvider) echoPort).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
				"http://localhost:9080/test-war/echo");
	}

	private EchoPortType echoPort;

	@Test
	public void testEcho() {
		Assert.assertEquals("5", echoPort.echoString("5"));
	}

	@Test
	public void testEcho2() {
		Assert.assertEquals(new Integer(5), echoPort.echoInt(5));
	}

	@Test
	public void testEcho3() {
		UUID uuid = UUID.randomUUID();
		Assert.assertEquals(uuid.toString(), echoPort.echoOMElement(uuid.toString()));
	}

	@Test
	public void testEcho4() {
		SimpleBean expected = new SimpleBean();
		expected.getAR().addAll(Arrays.asList("foo", "bar"));
		expected.getBR().addAll(Arrays.asList("hello", "world"));
		expected.setC(42);
		SimpleBean result = echoPort.echoStringArrays(Arrays.asList("foo", "bar"), Arrays.asList("hello", "world"), 42);
		Assert.assertEquals(expected.getAR(), result.getAR());
		Assert.assertEquals(expected.getBR(), result.getBR());
		Assert.assertEquals(expected.getC(), result.getC());
	}

	@Test(expected = WebServiceException.class)
	public void testFault() {
		EchoPortType echoPort = new Echo().getEchoHttpSoap11Endpoint();
		((BindingProvider) echoPort).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
				"http://localhost:9080/test-war/echo");
		echoPort.throwAxisFault();
	}

}
