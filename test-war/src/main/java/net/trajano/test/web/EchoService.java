package net.trajano.test.web;

import java.util.List;

import javax.jws.WebService;
import javax.xml.ws.soap.MTOM;

import org.wso2.carbon.core.services.echo.xsd.SimpleBean;

@MTOM
@WebService(endpointInterface = "org.wso2.carbon.core.services.echo.EchoPortType")
public class EchoService {

	public SimpleBean echoStringArrays(List<String> a, List<String> b, Integer c) {
		SimpleBean ret = new SimpleBean();
		ret.setC(c);
		ret.getAR().addAll(a);
		ret.getBR().addAll(b);
		return ret;
	}

	public Object echoOMElement(Object omEle) {
		return omEle;
	}

	public Integer echoInt(Integer in) {
		System.out.println("int = " + in);
		return in;
	}

	public String throwAxisFault() {
		throw new RuntimeException("FAULT");
	}

	public String echoString(String in) {
		System.out.println(in);
		return in;
	}

}
