/** 
 * This test sends a new action to the action scheduler and verifies that the action shows up in the action queue.
 */
@Test public void testActionSchedule() throws Exception {
assertTrue(ac.get(0) instanceof ExecutionCommand);
assertEquals("1-977",((ExecutionCommand)(ac.get(0))).getCommandId());
assertTrue(ac.get(0) instanceof ExecutionCommand);
assertEquals("1-977",((ExecutionCommand)(ac.get(0))).getCommandId());
}