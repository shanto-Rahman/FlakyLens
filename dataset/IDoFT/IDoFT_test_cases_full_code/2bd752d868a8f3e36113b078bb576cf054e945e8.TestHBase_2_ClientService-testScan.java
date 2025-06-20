@Test public void testScan() throws InitializationException, IOException {
  final String tableName="nifi";
  final TestRunner runner=TestRunners.newTestRunner(TestProcessor.class);
  final Table table=Mockito.mock(Table.class);
  when(table.getName()).thenReturn(TableName.valueOf(tableName));
  final MockHBaseClientService service=configureHBaseClientService(runner,table);
  runner.assertValid(service);
  final long now=System.currentTimeMillis();
  final Map<String,String> cells=new HashMap<>();
  cells.put("greeting","hello");
  cells.put("name","nifi");
  service.addResult("row0",cells,now - 2);
  service.addResult("row1",cells,now - 1);
  service.addResult("row2",cells,now - 1);
  service.addResult("row3",cells,now);
  final CollectingResultHandler handler=new CollectingResultHandler();
  final HBaseClientService hBaseClientService=runner.getProcessContext().getProperty(TestProcessor.HBASE_CLIENT_SERVICE).asControllerService(HBaseClientService.class);
  hBaseClientService.scan(tableName,new ArrayList<Column>(),null,now,handler);
  assertEquals(4,handler.results.size());
  final ResultCell[] results=handler.results.get("row0");
  assertNotNull(results);
  assertEquals(2,results.length);
  verifyResultCell(results[0],COL_FAM,"greeting","hello");
  verifyResultCell(results[1],COL_FAM,"name","nifi");
}
