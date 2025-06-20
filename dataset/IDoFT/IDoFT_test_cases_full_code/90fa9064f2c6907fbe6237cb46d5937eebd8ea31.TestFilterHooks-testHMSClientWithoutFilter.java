/** 
 * Disable filtering at HMS client By default, the HMS server side filtering is diabled, so we can see HMS client filtering behavior
 * @throws Exception
 */
@Test public void testHMSClientWithoutFilter() throws Exception {
  MetastoreConf.setBoolVar(conf,ConfVars.METASTORE_CLIENT_FILTER_ENABLED,false);
  DBNAME1="db_testHMSClientWithoutFilter_1";
  DBNAME2="db_testHMSClientWithoutFilter_2";
  creatEnv(conf);
  assertNotNull(client.getTable(DBNAME1,TAB1));
  assertEquals(2,client.getTables(DBNAME1,"*").size());
  assertEquals(2,client.getAllTables(DBNAME1).size());
  assertEquals(1,client.getTables(DBNAME1,TAB2).size());
  assertEquals(0,client.getAllTables(DBNAME2).size());
  assertNotNull(client.getDatabase(DBNAME1));
  assertEquals(2,client.getDatabases("*testHMSClientWithoutFilter*").size());
  assertEquals(1,client.getDatabases(DBNAME1).size());
  assertNotNull(client.getPartition(DBNAME1,TAB2,"name=value1"));
  assertEquals(1,client.getPartitionsByNames(DBNAME1,TAB2,Lists.newArrayList("name=value1")).size());
}
