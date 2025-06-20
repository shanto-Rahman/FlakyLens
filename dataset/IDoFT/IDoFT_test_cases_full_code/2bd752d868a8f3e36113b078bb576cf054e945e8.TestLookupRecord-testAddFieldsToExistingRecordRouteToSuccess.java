@Test public void testAddFieldsToExistingRecordRouteToSuccess() throws InitializationException {
  final RecordLookup lookupService=new RecordLookup();
  runner.addControllerService("lookup",lookupService);
  runner.enableControllerService(lookupService);
  runner.setProperty(LookupRecord.ROUTING_STRATEGY,LookupRecord.ROUTE_TO_SUCCESS);
  final List<RecordField> fields=new ArrayList<>();
  fields.add(new RecordField("favorite",RecordFieldType.STRING.getDataType(),false));
  fields.add(new RecordField("least",RecordFieldType.STRING.getDataType(),true));
  final RecordSchema schema=new SimpleRecordSchema(fields);
  final Record sports=new MapRecord(schema,new HashMap<>());
  sports.setValue("favorite","basketball");
  sports.setValue("least","soccer");
  lookupService.addValue("John Doe",sports);
  recordReader=new MockRecordParser();
  recordReader.addSchemaField("name",RecordFieldType.STRING);
  recordReader.addSchemaField("age",RecordFieldType.INT);
  recordReader.addRecord("John Doe",48);
  recordReader.addRecord("Jane Doe",47);
  runner.addControllerService("reader",recordReader);
  runner.enableControllerService(recordReader);
  runner.setProperty("lookup","/name");
  runner.setProperty(LookupRecord.RESULT_RECORD_PATH,"/");
  runner.setProperty(LookupRecord.RESULT_CONTENTS,LookupRecord.RESULT_RECORD_FIELDS);
  runner.enqueue("");
  runner.run();
  final MockFlowFile out=runner.getFlowFilesForRelationship(LookupRecord.REL_SUCCESS).get(0);
  out.assertContentEquals("John Doe,48,soccer,basketball\nJane Doe,47\n");
}
