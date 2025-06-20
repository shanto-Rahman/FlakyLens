@Test public void testScanToContentWithStringValues(){
  final Map<String,String> cells=new HashMap<>();
  cells.put("cq1","val1");
  cells.put("cq2","val2");
  final long ts1=123456789;
  hBaseClientService.addResult("row1",cells,ts1);
  hBaseClientService.addResult("row2",cells,ts1);
  runner.setProperty(ScanHBase.TABLE_NAME,"table1");
  runner.setProperty(ScanHBase.START_ROW,"row1");
  runner.setProperty(ScanHBase.END_ROW,"row2");
  runner.setProperty(ScanHBase.TIME_RANGE_MIN,"0");
  runner.setProperty(ScanHBase.TIME_RANGE_MAX,"1111111110");
  runner.setProperty(ScanHBase.LIMIT_ROWS,"10");
  runner.setProperty(ScanHBase.REVERSED_SCAN,"false");
  runner.setProperty(ScanHBase.BULK_SIZE,"10");
  runner.enqueue("trigger flow file");
  runner.run();
  runner.assertTransferCount(ScanHBase.REL_FAILURE,0);
  runner.assertTransferCount(ScanHBase.REL_SUCCESS,1);
  runner.assertTransferCount(ScanHBase.REL_ORIGINAL,1);
  MockFlowFile flowFile=runner.getFlowFilesForRelationship(ScanHBase.REL_SUCCESS).get(0);
  flowFile.assertContentEquals("[{\"row\":\"row1\", \"cells\": [" + "{\"fam\":\"nifi\",\"qual\":\"cq1\",\"val\":\"val1\",\"ts\":" + ts1 + "}, "+ "{\"fam\":\"nifi\",\"qual\":\"cq2\",\"val\":\"val2\",\"ts\":"+ ts1+ "}]},\n"+ "{\"row\":\"row2\", \"cells\": ["+ "{\"fam\":\"nifi\",\"qual\":\"cq1\",\"val\":\"val1\",\"ts\":"+ ts1+ "}, "+ "{\"fam\":\"nifi\",\"qual\":\"cq2\",\"val\":\"val2\",\"ts\":"+ ts1+ "}]}]");
  flowFile.assertAttributeEquals(ScanHBase.HBASE_ROWS_COUNT_ATTR,"2");
  flowFile=runner.getFlowFilesForRelationship(ScanHBase.REL_ORIGINAL).get(0);
  flowFile.assertAttributeEquals("scanhbase.results.found",Boolean.TRUE.toString());
  Assert.assertEquals(1,hBaseClientService.getNumScans());
}
