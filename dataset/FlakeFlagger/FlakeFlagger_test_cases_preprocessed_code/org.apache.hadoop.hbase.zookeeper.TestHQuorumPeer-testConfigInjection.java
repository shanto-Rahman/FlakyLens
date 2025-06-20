/** 
 * @throws Exception  
 */
public void testConfigInjection() throws Exception {
assertEquals(dataDir.toString(),properties.get("dataDir"));
assertEquals(Integer.valueOf(2181),Integer.valueOf(properties.getProperty("clientPort")));
assertEquals("localhost:2888:3888",properties.get("server.0"));
assertEquals(dataDir.toString(),config.getDataDir());
assertEquals(2181,config.getClientPortAddress().getPort());
assertEquals(1,servers.size());
assertTrue(servers.containsKey(Long.valueOf(0)));
assertEquals("localhost",server.addr.getHostName());
assertEquals("foo.bar:2888:3888",properties.get("server.0"));
assertEquals("foo.bar",server.addr.getHostName());
}