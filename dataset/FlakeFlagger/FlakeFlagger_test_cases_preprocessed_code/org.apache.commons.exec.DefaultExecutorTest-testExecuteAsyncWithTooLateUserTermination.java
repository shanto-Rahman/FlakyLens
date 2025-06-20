/** 
 * Start a async process and try to terminate it manually but the process was already terminated by the watchdog.
 */
public void testExecuteAsyncWithTooLateUserTermination() throws Exception {
Thread.sleep(6000);
assertTrue(watchdog.killedProcess());
}