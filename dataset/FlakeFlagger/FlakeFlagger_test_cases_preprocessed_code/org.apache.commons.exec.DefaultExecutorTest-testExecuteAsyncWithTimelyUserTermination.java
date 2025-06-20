/** 
 * Start a async process and terminate it manually before the wacthdog timeout occurs. 
 */
public void testExecuteAsyncWithTimelyUserTermination() throws Exception {
Thread.sleep(2000);
assertTrue(watchdog.killedProcess());
}