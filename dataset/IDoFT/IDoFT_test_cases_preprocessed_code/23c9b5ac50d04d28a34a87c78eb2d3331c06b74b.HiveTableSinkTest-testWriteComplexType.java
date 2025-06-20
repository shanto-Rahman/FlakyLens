@Test public void testWriteComplexType() throws Exception {
tableEnv.registerCatalog("hive",hiveCatalog);//RW
List<String> result=hiveShell.executeQuery("select * from " + tblName);//RW
assertEquals(1,result.size());
assertEquals("[1,2,3]\t{1:\"a\",2:\"b\"}\t{\"f1\":3,\"f2\":\"c\"}",result.get(0));
hiveCatalog.dropTable(tablePath,false);//RW
}