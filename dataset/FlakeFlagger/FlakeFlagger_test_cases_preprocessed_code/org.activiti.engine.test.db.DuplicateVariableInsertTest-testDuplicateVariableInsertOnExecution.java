/** 
 * Test for ACT-1887: Inserting the same new variable at the same time, from 2 different threads, using 2 modified commands that use a barrier for starting and a barrier for completing the command, so they each insert a new variable guaranteed.
 */
public void testDuplicateVariableInsertOnExecution() throws Exception {
firstInsertThread.start();
secondInsertThread.start();
firstInsertThread.join();
secondInsertThread.join();
assertEquals(1,exceptions.size());
assertEquals(1,variables.size());
assertEquals("12345",variables.get("var"));
}