@Test public void testData() throws Exception {
  FileInputStream fileInputStream=new FileInputStream(tmpAvro);
  ByteArrayOutputStream out=new ByteArrayOutputStream();
  int readedBytes;
  byte[] buf=new byte[1024];
  while ((readedBytes=fileInputStream.read(buf)) > 0) {
    out.write(buf,0,readedBytes);
  }
  out.close();
  Map<String,String> attributes=Collections.singletonMap(CoreAttributes.FILENAME.key(),"test.avro");
  runner.enqueue(out.toByteArray(),attributes);
  runner.run();
  MockFlowFile resultFlowFile=runner.getFlowFilesForRelationship(ConvertAvroToParquet.SUCCESS).get(0);
  byte[] resultContents=runner.getContentAsByteArray(resultFlowFile);
  FileOutputStream fos=new FileOutputStream(tmpParquet);
  fos.write(resultContents);
  fos.flush();
  fos.close();
  Configuration conf=new Configuration();
  ParquetReader<Group> reader=ParquetReader.builder(new GroupReadSupport(),new Path(tmpParquet.getAbsolutePath())).withConf(conf).build();
  List<Group> parquetRecords=new ArrayList<>();
  Group current;
  current=reader.read();
  while (current != null) {
    parquetRecords.add(current);
    current=reader.read();
  }
  Group firstRecord=parquetRecords.get(0);
  assertEquals(firstRecord.getInteger("myint",0),1);
  assertEquals(firstRecord.getLong("mylong",0),2);
  assertTrue(firstRecord.getBoolean("myboolean",0));
  assertEquals(firstRecord.getFloat("myfloat",0),3.1,0.0001);
  assertEquals(firstRecord.getDouble("mydouble",0),4.1,0.001);
  assertEquals(firstRecord.getString("mybytes",0),"hello");
  assertEquals(firstRecord.getString("mystring",0),"hello");
  assertEquals(firstRecord.getGroup("mynestedrecord",0).getInteger("mynestedint",0),1);
  assertEquals(firstRecord.getGroup("myarray",0).getGroup("list",0).getInteger("element",0),1);
  assertEquals(firstRecord.getGroup("myarray",0).getGroup("list",1).getInteger("element",0),2);
  assertEquals(firstRecord.getGroup("mymap",0).getGroup("key_value",0).getInteger("value",0),1);
  assertEquals(firstRecord.getGroup("mymap",0).getGroup("key_value",1).getInteger("value",0),2);
  assertEquals(firstRecord.getString("myfixed",0),"A");
}
