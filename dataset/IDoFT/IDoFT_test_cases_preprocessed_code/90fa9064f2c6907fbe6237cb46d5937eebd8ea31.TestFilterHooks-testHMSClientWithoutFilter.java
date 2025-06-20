/** 
 * Disable filtering at HMS client By default, the HMS server side filtering is diabled, so we can see HMS client filtering behavior
 * @throws Exception
 */
@Test public void testHMSClientWithoutFilter() throws Exception {
MetastoreConf.setBoolVar(conf,ConfVars.METASTORE_CLIENT_FILTER_ENABLED,false);//RW
DBNAME1="db_testHMSClientWithoutFilter_1";//RW
DBNAME2="db_testHMSClientWithoutFilter_2";//RW
creatEnv(conf);//RW
assertNotNull(client.getTable(DBNAME1,TAB1));//RW
assertEquals(2,client.getTables(DBNAME1,"*").size());//RW
assertEquals(2,client.getAllTables(DBNAME1).size());//RW
assertEquals(1,client.getTables(DBNAME1,TAB2).size());//RW
assertEquals(0,client.getAllTables(DBNAME2).size());//RW
assertNotNull(client.getDatabase(DBNAME1));//RW
assertEquals(2,client.getDatabases("*testHMSClientWithoutFilter*").size());//RW
assertEquals(1,client.getDatabases(DBNAME1).size());//RW
assertNotNull(client.getPartition(DBNAME1,TAB2,"name=value1"));//RW
assertEquals(1,client.getPartitionsByNames(DBNAME1,TAB2,Lists.newArrayList("name=value1")).size());//RW
}