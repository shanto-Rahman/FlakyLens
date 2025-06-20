@Test public void testContentField() throws IOException, InitializationException {
  TestRunner runner=setup("src/test/resources/xml/testschema2");
  runner.setProperty(reader,XMLReader.CONTENT_FIELD_NAME,"${" + CONTENT_NAME + "}");
  runner.setProperty(reader,XMLReader.RECORD_FORMAT,XMLReader.RECORD_ARRAY);
  runner.enableControllerService(reader);
  InputStream is=new FileInputStream("src/test/resources/xml/people_tag_in_characters.xml");
  runner.enqueue(is,Collections.singletonMap(CONTENT_NAME,"CONTENT"));
  runner.run();
  List<MockFlowFile> flowFile=runner.getFlowFilesForRelationship(TestXMLReaderProcessor.SUCCESS);
  List<String> records=Arrays.asList(new String(runner.getContentAsByteArray(flowFile.get(0))).split("\n"));
  assertEquals(5,records.size());
  assertEquals("MapRecord[{ID=P1, NAME=MapRecord[{CONTENT=Cleve Butler, ATTR=attr content, INNER=inner content}], AGE=42}]",records.get(0));
  assertEquals("MapRecord[{ID=P2, NAME=MapRecord[{CONTENT=Ainslie Fletcher, ATTR=attr content, INNER=inner content}], AGE=33}]",records.get(1));
  assertEquals("MapRecord[{ID=P3, NAME=MapRecord[{CONTENT=Amélie Bonfils, ATTR=attr content, INNER=inner content}], AGE=74}]",records.get(2));
  assertEquals("MapRecord[{ID=P4, NAME=MapRecord[{CONTENT=Elenora Scrivens, ATTR=attr content, INNER=inner content}], AGE=16}]",records.get(3));
  assertEquals("MapRecord[{ID=P5, NAME=MapRecord[{INNER=inner content}]}]",records.get(4));
}
