/** 
 * Test copying of map
 */
public void testCopyMap() throws Exception {
assertTrue(result.size() == 1);
assertTrue(procEnvironment.size() == 1);
assertEquals("/usr/opt/java",result.get("JAVA_HOME"));
assertTrue(result.size() == 0);
assertTrue(procEnvironment.size() == 1);
}