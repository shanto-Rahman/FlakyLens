/** 
 * Test the proper handling of ProcessDestroyer for an synchronous process.
 */
public void testExecuteWithProcessDestroyer() throws Exception {
assertTrue(processDestroyer.size() == 0);
assertTrue(processDestroyer.isAddedAsShutdownHook() == false);
assertEquals("FOO..",baos.toString().trim());
assertEquals(0,exitValue);
assertTrue(processDestroyer.size() == 0);
assertTrue(processDestroyer.isAddedAsShutdownHook() == false);
}