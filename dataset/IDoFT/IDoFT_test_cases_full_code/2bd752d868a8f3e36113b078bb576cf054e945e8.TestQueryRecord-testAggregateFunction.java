@Test public void testAggregateFunction() throws InitializationException {
  final MockRecordParser parser=new MockRecordParser();
  parser.addSchemaField("name",RecordFieldType.STRING);
  parser.addSchemaField("points",RecordFieldType.INT);
  parser.addRecord("Tom",1);
  parser.addRecord("Jerry",2);
  parser.addRecord("Tom",99);
  final MockRecordWriter writer=new MockRecordWriter("\"name\",\"points\"");
  TestRunner runner=getRunner();
  runner.addControllerService("parser",parser);
  runner.enableControllerService(parser);
  runner.addControllerService("writer",writer);
  runner.enableControllerService(writer);
  runner.setProperty(REL_NAME,"select name, sum(points) as points from FLOWFILE GROUP BY name");
  runner.setProperty(QueryRecord.RECORD_READER_FACTORY,"parser");
  runner.setProperty(QueryRecord.RECORD_WRITER_FACTORY,"writer");
  runner.enqueue("");
  runner.run();
  runner.assertTransferCount(REL_NAME,1);
  final MockFlowFile flowFileOut=runner.getFlowFilesForRelationship(REL_NAME).get(0);
  flowFileOut.assertContentEquals("\"name\",\"points\"\n\"Tom\",\"100\"\n\"Jerry\",\"2\"\n");
}
