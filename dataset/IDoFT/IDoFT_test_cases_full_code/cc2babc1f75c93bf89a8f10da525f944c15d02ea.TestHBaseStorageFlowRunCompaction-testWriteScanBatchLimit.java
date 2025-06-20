@Test public void testWriteScanBatchLimit() throws Exception {
  String rowKey="nonNumericRowKey";
  String column="nonNumericColumnName";
  String value="nonNumericValue";
  String column2="nonNumericColumnName2";
  String value2="nonNumericValue2";
  String column3="nonNumericColumnName3";
  String value3="nonNumericValue3";
  String column4="nonNumericColumnName4";
  String value4="nonNumericValue4";
  byte[] rowKeyBytes=Bytes.toBytes(rowKey);
  byte[] columnNameBytes=Bytes.toBytes(column);
  byte[] valueBytes=Bytes.toBytes(value);
  byte[] columnName2Bytes=Bytes.toBytes(column2);
  byte[] value2Bytes=Bytes.toBytes(value2);
  byte[] columnName3Bytes=Bytes.toBytes(column3);
  byte[] value3Bytes=Bytes.toBytes(value3);
  byte[] columnName4Bytes=Bytes.toBytes(column4);
  byte[] value4Bytes=Bytes.toBytes(value4);
  Put p=new Put(rowKeyBytes);
  p.addColumn(FlowRunColumnFamily.INFO.getBytes(),columnNameBytes,valueBytes);
  p.addColumn(FlowRunColumnFamily.INFO.getBytes(),columnName2Bytes,value2Bytes);
  p.addColumn(FlowRunColumnFamily.INFO.getBytes(),columnName3Bytes,value3Bytes);
  p.addColumn(FlowRunColumnFamily.INFO.getBytes(),columnName4Bytes,value4Bytes);
  Configuration hbaseConf=util.getConfiguration();
  Connection conn=null;
  conn=ConnectionFactory.createConnection(hbaseConf);
  Table flowRunTable=conn.getTable(BaseTableRW.getTableName(hbaseConf,FlowRunTableRW.TABLE_NAME_CONF_NAME,FlowRunTableRW.DEFAULT_TABLE_NAME));
  flowRunTable.put(p);
  String rowKey2="nonNumericRowKey2";
  byte[] rowKey2Bytes=Bytes.toBytes(rowKey2);
  p=new Put(rowKey2Bytes);
  p.addColumn(FlowRunColumnFamily.INFO.getBytes(),columnNameBytes,valueBytes);
  p.addColumn(FlowRunColumnFamily.INFO.getBytes(),columnName2Bytes,value2Bytes);
  p.addColumn(FlowRunColumnFamily.INFO.getBytes(),columnName3Bytes,value3Bytes);
  p.addColumn(FlowRunColumnFamily.INFO.getBytes(),columnName4Bytes,value4Bytes);
  flowRunTable.put(p);
  String rowKey3="nonNumericRowKey3";
  byte[] rowKey3Bytes=Bytes.toBytes(rowKey3);
  p=new Put(rowKey3Bytes);
  p.addColumn(FlowRunColumnFamily.INFO.getBytes(),columnNameBytes,valueBytes);
  p.addColumn(FlowRunColumnFamily.INFO.getBytes(),columnName2Bytes,value2Bytes);
  p.addColumn(FlowRunColumnFamily.INFO.getBytes(),columnName3Bytes,value3Bytes);
  p.addColumn(FlowRunColumnFamily.INFO.getBytes(),columnName4Bytes,value4Bytes);
  flowRunTable.put(p);
  Scan s=new Scan();
  s.addFamily(FlowRunColumnFamily.INFO.getBytes());
  s.setStartRow(rowKeyBytes);
  int batchLimit=2;
  s.setBatch(batchLimit);
  ResultScanner scanner=flowRunTable.getScanner(s);
  for (  Result result : scanner) {
    assertNotNull(result);
    assertTrue(!result.isEmpty());
    assertTrue(result.rawCells().length <= batchLimit);
    Map<byte[],byte[]> values=result.getFamilyMap(FlowRunColumnFamily.INFO.getBytes());
    assertTrue(values.size() <= batchLimit);
  }
  s=new Scan();
  s.addFamily(FlowRunColumnFamily.INFO.getBytes());
  s.setStartRow(rowKeyBytes);
  batchLimit=3;
  s.setBatch(batchLimit);
  scanner=flowRunTable.getScanner(s);
  for (  Result result : scanner) {
    assertNotNull(result);
    assertTrue(!result.isEmpty());
    assertTrue(result.rawCells().length <= batchLimit);
    Map<byte[],byte[]> values=result.getFamilyMap(FlowRunColumnFamily.INFO.getBytes());
    assertTrue(values.size() <= batchLimit);
  }
  s=new Scan();
  s.addFamily(FlowRunColumnFamily.INFO.getBytes());
  s.setStartRow(rowKeyBytes);
  batchLimit=1000;
  s.setBatch(batchLimit);
  scanner=flowRunTable.getScanner(s);
  int rowCount=0;
  for (  Result result : scanner) {
    assertNotNull(result);
    assertTrue(!result.isEmpty());
    assertTrue(result.rawCells().length <= batchLimit);
    Map<byte[],byte[]> values=result.getFamilyMap(FlowRunColumnFamily.INFO.getBytes());
    assertTrue(values.size() <= batchLimit);
    assertEquals(4,values.size());
    rowCount++;
  }
  assertEquals(3,rowCount);
  s=new Scan();
  s.addFamily(FlowRunColumnFamily.INFO.getBytes());
  s.setStartRow(rowKeyBytes);
  batchLimit=-2992;
  s.setBatch(batchLimit);
  scanner=flowRunTable.getScanner(s);
  rowCount=0;
  for (  Result result : scanner) {
    assertNotNull(result);
    assertTrue(!result.isEmpty());
    assertEquals(4,result.rawCells().length);
    Map<byte[],byte[]> values=result.getFamilyMap(FlowRunColumnFamily.INFO.getBytes());
    assertEquals(4,values.size());
    rowCount++;
  }
  assertEquals(3,rowCount);
}
