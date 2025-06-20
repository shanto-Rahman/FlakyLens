@Test public void testFetchToAttributesWithStringValues(){
  final Map<String,String> cells=new HashMap<>();
  cells.put("cq1","val1");
  cells.put("cq2","val2");
  final long ts1=123456789;
  hBaseClientService.addResult("row1",cells,ts1);
  runner.setProperty(FetchHBaseRow.AUTHORIZATIONS,"");
  runner.setProperty(FetchHBaseRow.TABLE_NAME,"table1");
  runner.setProperty(FetchHBaseRow.ROW_ID,"row1");
  runner.setProperty(FetchHBaseRow.DESTINATION,FetchHBaseRow.DESTINATION_ATTRIBUTES);
  runner.enqueue("trigger flow file");
  runner.run();
  runner.assertTransferCount(FetchHBaseRow.REL_FAILURE,0);
  runner.assertTransferCount(FetchHBaseRow.REL_SUCCESS,1);
  runner.assertTransferCount(FetchHBaseRow.REL_NOT_FOUND,0);
  final MockFlowFile flowFile=runner.getFlowFilesForRelationship(FetchHBaseRow.REL_SUCCESS).get(0);
  flowFile.assertAttributeEquals(FetchHBaseRow.HBASE_ROW_ATTR,"{\"row\":\"row1\", \"cells\": [" + "{\"fam\":\"nifi\",\"qual\":\"cq1\",\"val\":\"val1\",\"ts\":" + ts1 + "}, "+ "{\"fam\":\"nifi\",\"qual\":\"cq2\",\"val\":\"val2\",\"ts\":"+ ts1+ "}]}");
  Assert.assertEquals(1,hBaseClientService.getNumScans());
}
