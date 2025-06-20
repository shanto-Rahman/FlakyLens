/** 
 * Invoke the error script but define that "1" is a bad exit value and therefore no exception should be thrown.
 */
public void testExecuteWithCustomExitValue2() throws Exception {
fail("Must throw ExecuteException");
assertEquals(1,e.getExitValue());
}