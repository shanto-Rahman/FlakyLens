@Test public void testGetClusterHostInfo() throws AmbariException {
assertEquals(2,info.get("slave_hosts").size());
assertEquals(1,info.get("hbase_master_host").size());
assertEquals("h1",info.get("hbase_master_host").get(0));
}