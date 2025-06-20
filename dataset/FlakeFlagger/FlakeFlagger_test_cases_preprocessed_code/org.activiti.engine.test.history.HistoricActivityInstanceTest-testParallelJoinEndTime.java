/** 
 * Test to validate fix for ACT-1549: endTime of joining parallel gateway is not set
 */
@Deployment public void testParallelJoinEndTime(){
assertEquals(2,tasksToComplete.size());
assertNotNull(historicActivityInstance);
assertEquals(2,historicActivityInstance.size());
assertNotNull(historicActivityInstance.get(0).getEndTime());
assertNotNull(historicActivityInstance.get(1).getEndTime());
}