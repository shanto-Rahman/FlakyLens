@Test public void testGetSource() throws Exception {
  Source source=definition.getSource();
  Assert.assertNotNull("Source is null",source);
  DOMResult result=new DOMResult();
  transformer.transform(source,result);
  DocumentBuilderFactory documentBuilderFactory=DocumentBuilderFactory.newInstance();
  documentBuilderFactory.setNamespaceAware(true);
  DocumentBuilder documentBuilder=documentBuilderFactory.newDocumentBuilder();
  Document expected=documentBuilder.parse(getClass().getResourceAsStream("complete.wsdl"));
  assertXMLEqual(expected,(Document)result.getNode());
}
