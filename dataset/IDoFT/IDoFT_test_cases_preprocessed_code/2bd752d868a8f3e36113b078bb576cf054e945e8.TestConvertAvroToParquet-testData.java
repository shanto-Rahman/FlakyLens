@Test public void testData() throws Exception {
FileInputStream fileInputStream=new FileInputStream(tmpAvro);
FileOutputStream fos=new FileOutputStream(tmpParquet);
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