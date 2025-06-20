/** 
 * Start a scipt looping forever and check if the ExecuteWatchdog kicks in killing the run away process.
 */
public void testExecuteWatchdog() throws Exception {
executor.setWorkingDirectory(new File("."));//RO
assertTrue(executor.getWatchdog().killedProcess());
fail(t.getMessage());
fail("Process was not killed");
}