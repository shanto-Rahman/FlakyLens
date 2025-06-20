/** 
 * Test to validate fix for ACT-1399: Boundary-event and event-based auditing
 */
@Deployment public void testBoundaryEvent(){
assertNotNull(task);
assertEquals(0L,runtimeService.createProcessInstanceQuery().processInstanceId(processInstance.getId()).count());
assertNull(historicActivityInstance);
assertEquals(0L,runtimeService.createProcessInstanceQuery().processInstanceId(processInstance.getId()).count());
assertNotNull(historicActivityInstance);
assertNotNull(historicActivityInstance.getStartTime());
assertNotNull(historicActivityInstance.getEndTime());
}