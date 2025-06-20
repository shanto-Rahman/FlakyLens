@Test public void testSoap11And12() throws Exception {
  Resource resource=new ClassPathResource("single.xsd",getClass());
  SimpleXsdSchema schema=new SimpleXsdSchema(resource);
  schema.afterPropertiesSet();
  definition.setSchema(schema);
  definition.setTargetNamespace("http://www.springframework.org/spring-ws/single/definitions");
  definition.setPortTypeName("Order");
  definition.setLocationUri("http://localhost:8080/");
  definition.setCreateSoap11Binding(true);
  definition.setCreateSoap12Binding(true);
  definition.afterPropertiesSet();
  DOMResult domResult=new DOMResult();
  transformer.transform(definition.getSource(),domResult);
  Document result=(Document)domResult.getNode();
  Document expected=documentBuilder.parse(getClass().getResourceAsStream("soap-11-12.wsdl"));
  assertXMLEqual("Invalid WSDL built",expected,result);
}
