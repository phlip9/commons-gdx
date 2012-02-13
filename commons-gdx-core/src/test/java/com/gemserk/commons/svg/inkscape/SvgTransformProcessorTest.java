package com.gemserk.commons.svg.inkscape;

import java.io.InputStream;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.gemserk.commons.svg.processors.SvgConfigureIdProcessor;
import com.gemserk.commons.svg.processors.SvgDocumentProcessor;
import com.gemserk.commons.svg.processors.SvgElementProcessor;
import com.gemserk.commons.svg.processors.SvgTransformProcessor;
import com.gemserk.commons.svg.processors.SvgUseProcessor;


public class SvgTransformProcessorTest {

	public class SvgLogProcessor extends SvgElementProcessor {

		@Override
		public boolean processElement(Element element) {

			if (!SvgNamespace.isUse(element) && !SvgNamespace.isImage(element) && !SvgNamespace.isSvg(element))
				return true;

			System.out.println("id: " + SvgNamespace.getId(element));
			System.out.println("type: " + element.getNodeName());
			System.out.println("local: " + SvgNamespace.getTransform(element));
			System.out.println("absolute: " + GemserkNamespace.getAbsoluteTransform(element));

			return true;
		}

	}

	@Test
	public void test() {
		InputStream svgStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test-svguse.svg");

		DocumentParser documentParser = new DocumentParser();
		Document document = documentParser.parse(svgStream);

		SvgDocumentProcessor svgDocumentProcessor = new SvgDocumentProcessor();

		svgDocumentProcessor.process(document, new SvgConfigureIdProcessor());
		svgDocumentProcessor.process(document, new SvgTransformProcessor());
		svgDocumentProcessor.process(document, new SvgUseProcessor());
		svgDocumentProcessor.process(document, new SvgLogProcessor());
	}
}
