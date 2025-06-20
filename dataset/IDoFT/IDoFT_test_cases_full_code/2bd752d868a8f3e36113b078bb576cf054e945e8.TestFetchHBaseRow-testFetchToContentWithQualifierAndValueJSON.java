@Test public void testFetchToContentWithQualifierAndValueJSON(){
  final Map<String,String> cells=new HashMap<>();
  cells.put("cq1","val1");
  cells.put("cq2","val2");
  hBaseClientService.addResult("row1",cells,System.currentTimeMillis());
  runner.setProperty(FetchHBaseRow.TABLE_NAME,"table1");
  runner.setProperty(FetchHBaseRow.ROW_ID,"row1");
  runner.setProperty(FetchHBaseRow.DESTINATION,FetchHBaseRow.DESTINATION_CONTENT);
  runner.setProperty(FetchHBaseRow.JSON_FORMAT,FetchHBaseRow.JSON_FORMAT_QUALIFIER_AND_VALUE);
  runner.enqueue("trigger flow file");
  runner.run();
  runner.assertTransferCount(FetchHBaseRow.REL_FAILURE,0);
  runner.assertTransferCount(FetchHBaseRow.REL_SUCCESS,1);
  runner.assertTransferCount(FetchHBaseRow.REL_NOT_FOUND,0);
  final MockFlowFile flowFile=runner.getFlowFilesForRelationship(FetchHBaseRow.REL_SUCCESS).get(0);
  flowFile.assertContentEquals("{\"cq1\":\"val1\", \"cq2\":\"val2\"}");
  Assert.assertEquals(1,hBaseClientService.getNumScans());
}
