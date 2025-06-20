/** 
 * We need delete of a znode to work at least.
 */
@Test public void testCommandLineWorks() throws Exception {
assertTrue(exception);
assertEquals(-1,ZKUtil.checkExists(zkw,znode));
}