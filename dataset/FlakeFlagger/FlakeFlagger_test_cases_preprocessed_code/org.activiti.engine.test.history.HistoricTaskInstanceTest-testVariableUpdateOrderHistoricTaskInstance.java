/** 
 * Test to validate fix for ACT-1939: HistoryService loads invalid task local variables for completed task
 */
@Deployment public void testVariableUpdateOrderHistoricTaskInstance() throws Exception {
assertNotNull(task);
assertEquals(9,varValue);
assertEquals(9,varValue);
}