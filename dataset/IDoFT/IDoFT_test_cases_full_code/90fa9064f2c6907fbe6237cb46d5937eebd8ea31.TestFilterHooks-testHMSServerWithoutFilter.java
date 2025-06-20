/** 
 * The default configuration should be disable filtering at HMS server Disable the HMS client side filtering in order to see HMS server filtering behavior
 * @throws Exception
 */
@Test public void testHMSServerWithoutFilter() throws Exception {
  MetastoreConf.setBoolVar(conf,ConfVars.METASTORE_CLIENT_FILTER_ENABLED,false);
  DBNAME1="db_testHMSServerWithoutFilter_1";
  DBNAME2="db_testHMSServerWithoutFilter_2";
  creatEnv(conf);
  assertNotNull(client.getTable(DBNAME1,TAB1));
  assertEquals(2,client.getTables(DBNAME1,"*").size());
  assertEquals(2,client.getAllTables(DBNAME1).size());
  assertEquals(1,client.getTables(DBNAME1,TAB2).size());
  assertEquals(0,client.getAllTables(DBNAME2).size());
  assertNotNull(client.getDatabase(DBNAME1));
  assertEquals(2,client.getDatabases("*testHMSServerWithoutFilter*").size());
  assertEquals(1,client.getDatabases(DBNAME1).size());
  assertNotNull(client.getPartition(DBNAME1,TAB2,"name=value1"));
  assertEquals(1,client.getPartitionsByNames(DBNAME1,TAB2,Lists.newArrayList("name=value1")).size());
}
