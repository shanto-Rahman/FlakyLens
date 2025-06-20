@Test public void testFetchSpecificColumnsToContentWithBase64(){
  final Map<String,String> cells=new HashMap<>();
  cells.put("cq1","val1");
  cells.put("cq2","val2");
  final long ts1=123456789;
  hBaseClientService.addResult("row1",cells,ts1);
  runner.setProperty(FetchHBaseRow.TABLE_NAME,"table1");
  runner.setProperty(FetchHBaseRow.ROW_ID,"row1");
  runner.setProperty(FetchHBaseRow.DESTINATION,FetchHBaseRow.DESTINATION_CONTENT);
  runner.setProperty(FetchHBaseRow.JSON_VALUE_ENCODING,FetchHBaseRow.ENCODING_BASE64);
  runner.enqueue("trigger flow file");
  runner.run();
  runner.assertTransferCount(FetchHBaseRow.REL_FAILURE,0);
  runner.assertTransferCount(FetchHBaseRow.REL_SUCCESS,1);
  runner.assertTransferCount(FetchHBaseRow.REL_NOT_FOUND,0);
  final String rowBase64=Base64.encodeBase64String("row1".getBytes(StandardCharsets.UTF_8));
  final String fam1Base64=Base64.encodeBase64String("nifi".getBytes(StandardCharsets.UTF_8));
  final String qual1Base64=Base64.encodeBase64String("cq1".getBytes(StandardCharsets.UTF_8));
  final String val1Base64=Base64.encodeBase64String("val1".getBytes(StandardCharsets.UTF_8));
  final String fam2Base64=Base64.encodeBase64String("nifi".getBytes(StandardCharsets.UTF_8));
  final String qual2Base64=Base64.encodeBase64String("cq2".getBytes(StandardCharsets.UTF_8));
  final String val2Base64=Base64.encodeBase64String("val2".getBytes(StandardCharsets.UTF_8));
  final MockFlowFile flowFile=runner.getFlowFilesForRelationship(FetchHBaseRow.REL_SUCCESS).get(0);
  flowFile.assertContentEquals("{\"row\":\"" + rowBase64 + "\", \"cells\": ["+ "{\"fam\":\""+ fam1Base64+ "\",\"qual\":\""+ qual1Base64+ "\",\"val\":\""+ val1Base64+ "\",\"ts\":"+ ts1+ "}, "+ "{\"fam\":\""+ fam2Base64+ "\",\"qual\":\""+ qual2Base64+ "\",\"val\":\""+ val2Base64+ "\",\"ts\":"+ ts1+ "}]}");
  Assert.assertEquals(1,hBaseClientService.getNumScans());
}
