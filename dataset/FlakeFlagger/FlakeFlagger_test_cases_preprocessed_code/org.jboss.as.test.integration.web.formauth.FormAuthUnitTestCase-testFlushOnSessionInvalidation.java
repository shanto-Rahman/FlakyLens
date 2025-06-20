/** 
 * Test that the war which uses <security-domain flushOnSessionInvalidation="true"> in the jboss-web.xml does not have any jaas security domain cache entries after the web session has been invalidated.
 */
@Test public void testFlushOnSessionInvalidation() throws Exception {
log.trace("+++ testFlushOnSessionInvalidation");//RW
assertNotNull(node);
assertTrue(USERNAME + " should be cached now.",cachedPrincipals.contains(USERNAME));
assertNotNull(node2);
assertFalse(USERNAME + " should no longer be cached.",cachedPrincipals2.contains(USERNAME));
}