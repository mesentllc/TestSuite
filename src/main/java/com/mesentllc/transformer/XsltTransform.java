package com.mesentllc.transformer;

import com.mesentllc.utils.ClassPathResourceUtil;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.xml.transform.StringResult;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;

public class XsltTransform {
	private static final String XSLT = ClassPathResourceUtil.getString("xsltTransformResources/FxspRodesUnmanifested.xslt");
	private static final String SOURCE_XML = ClassPathResourceUtil.getString("xsltTransformResources/smartpostUnmanifestedFromProd.xml");
	private static Unmarshaller unmarshaller;

	public static void main(String[] args) throws TransformerException, JAXBException {
		XsltTransform transform = new XsltTransform();
		JAXBContext jaxbContext = JAXBContext.newInstance(UnmanifestedPackageEvent.class);
		unmarshaller = jaxbContext.createUnmarshaller();
		transform.process();
	}

	private void process() throws TransformerException, JAXBException {
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer(new StreamSource(new StringReader(XSLT)));
		Result result = new StringResult();
		transformer.transform(new StreamSource(new StringReader(SOURCE_XML)), result);
		UnmanifestedPackageEvent event = (UnmanifestedPackageEvent)unmarshaller.unmarshal(new StringReader(result.toString()));
		System.out.println(ReflectionToStringBuilder.toString(event, ToStringStyle.JSON_STYLE));
	}
}
