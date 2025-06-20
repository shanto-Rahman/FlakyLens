/** 
 * Test prefixing of map
 */
public void testPrefixMap() throws Exception {
assertTrue(procEnvironment.size() == result.size());
assertEquals("/usr/opt/java",result.get("env.JAVA_HOME"));
}