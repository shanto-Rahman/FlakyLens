/** 
 * Test for http://jira.qos.ch/browse/LOGBACK-796
 */
@Test public void testFileShouldNotMatchFileNamePattern(){
assertTrue("Missing error: " + msg,containsMatch);
}