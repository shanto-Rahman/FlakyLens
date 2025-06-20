@Test public void testSingle() throws Exception {
  Resource resource=new ClassPathResource("single.xsd",getClass());
  SimpleXsdSchema schema=new SimpleXsdSchema(resource);
  schema.afterPropertiesSet();
  definition.setSchema(schema);
  definition.setTargetNamespace("http://www.springframework.org/spring-ws/single/definitions");
  definition.setPortTypeName("Order");
  definition.setLocationUri("http://localhost:8080/");
  definition.afterPropertiesSet();
  DOMResult domResult=new DOMResult();
  transformer.transform(definition.getSource(),domResult);
  Document result=(Document)domResult.getNode();
  Document expected=documentBuilder.parse(getClass().getResourceAsStream("single-inline.wsdl"));
  assertXMLEqual("Invalid WSDL built",expected,result);
}
