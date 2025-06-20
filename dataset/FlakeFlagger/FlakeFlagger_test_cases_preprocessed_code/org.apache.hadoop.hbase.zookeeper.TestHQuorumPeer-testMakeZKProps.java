/** 
 */
public void testMakeZKProps(){
assertEquals(dataDir.toString(),properties.get("dataDir"));
assertEquals(Integer.valueOf(21810),Integer.valueOf(properties.getProperty("clientPort")));
assertEquals("localhost:2888:3888",properties.get("server.0"));
assertEquals(null,properties.get("server.1"));
assertEquals(dataDir.toString(),properties.get("dataDir"));
assertEquals(Integer.valueOf(21810),Integer.valueOf(properties.getProperty("clientPort")));
assertEquals("a.foo.bar:2888:3888",properties.get("server.0"));
assertEquals("b.foo.bar:2888:3888",properties.get("server.1"));
assertEquals("c.foo.bar:2888:3888",properties.get("server.2"));
assertEquals(null,properties.get("server.3"));
}