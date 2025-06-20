@Test public void testAttributePrefix() throws IOException, InitializationException {
  TestRunner runner=setup("src/test/resources/xml/testschema");
  runner.setProperty(reader,XMLReader.ATTRIBUTE_PREFIX,"${" + ATTRIBUTE_PREFIX + "}");
  runner.setProperty(reader,XMLReader.RECORD_FORMAT,XMLReader.RECORD_ARRAY);
  runner.enableControllerService(reader);
  InputStream is=new FileInputStream("src/test/resources/xml/people.xml");
  runner.enqueue(is,Collections.singletonMap(ATTRIBUTE_PREFIX,"ATTR_"));
  runner.run();
  List<MockFlowFile> flowFile=runner.getFlowFilesForRelationship(TestXMLReaderProcessor.SUCCESS);
  List<String> records=Arrays.asList(new String(runner.getContentAsByteArray(flowFile.get(0))).split("\n"));
  assertEquals(4,records.size());
  assertEquals("MapRecord[{COUNTRY=USA, ATTR_ID=P1, NAME=Cleve Butler, AGE=42}]",records.get(0));
  assertEquals("MapRecord[{COUNTRY=UK, ATTR_ID=P2, NAME=Ainslie Fletcher, AGE=33}]",records.get(1));
  assertEquals("MapRecord[{COUNTRY=FR, ATTR_ID=P3, NAME=Amélie Bonfils, AGE=74}]",records.get(2));
  assertEquals("MapRecord[{COUNTRY=USA, ATTR_ID=P4, NAME=Elenora Scrivens, AGE=16}]",records.get(3));
}
