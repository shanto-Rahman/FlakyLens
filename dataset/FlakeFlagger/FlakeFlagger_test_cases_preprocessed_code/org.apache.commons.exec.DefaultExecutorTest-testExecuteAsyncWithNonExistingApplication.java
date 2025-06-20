/** 
 * Try to start an non-existing application asynchronously which should result in an exception.
 */
public void testExecuteAsyncWithNonExistingApplication() throws Exception {
Thread.sleep(2000);
assertEquals(Executor.INVALID_EXITVALUE,handler.getExitValue());
assertTrue(handler.getException() instanceof ExecuteException);
}