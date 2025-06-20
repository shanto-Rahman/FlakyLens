@Test public void testImport() throws Exception {
  ClassPathResource resource=new ClassPathResource("importing.xsd",getClass());
  CommonsXsdSchemaCollection schemaCollection=new CommonsXsdSchemaCollection(resource);
  schemaCollection.setInline(true);
  schemaCollection.afterPropertiesSet();
  definition.setSchemaCollection(schemaCollection);
  definition.setPortTypeName("Order");
  definition.setTargetNamespace("http://www.springframework.org/spring-ws/import/definitions");
  definition.setLocationUri("http://localhost:8080/");
  definition.afterPropertiesSet();
  DOMResult domResult=new DOMResult();
  transformer.transform(definition.getSource(),domResult);
  Document result=(Document)domResult.getNode();
  Document expected=documentBuilder.parse(getClass().getResourceAsStream("import-inline.wsdl"));
  assertXMLEqual("Invalid WSDL built",expected,result);
}
