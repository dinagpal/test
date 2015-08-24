package net.trajano.test.web;

import java.util.List;

import javax.jws.WebService;

import org.wso2.carbon.core.services.echo.xsd.SimpleBean;

@WebService(endpointInterface = "org.wso2.carbon.core.services.echo.EchoPortType")
public class EchoService {

	public SimpleBean echoStringArrays(List<String> a, List<String> b, Integer c) {
		SimpleBean ret = new SimpleBean();
		ret.setC( c);
		ret.getAR().addAll(a);
		ret.getBR().addAll(b);
		return ret;
	}

	public Object echoOMElement(Object omEle) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer echoInt(Integer in) {
		System.out.println("int = " + in);
		return in;
	}

	public String throwAxisFault() {
		// TODO Auto-generated method stub
		return null;
	}

	public String echoString(String in) {
		System.out.println(in);
		return in;
	}

}
