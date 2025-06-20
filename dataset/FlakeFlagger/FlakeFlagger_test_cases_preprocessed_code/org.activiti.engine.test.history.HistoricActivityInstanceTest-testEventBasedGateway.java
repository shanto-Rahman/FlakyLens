/** 
 * Test to validate fix for ACT-1399: Boundary-event and event-based auditing
 */
@Deployment public void testEventBasedGateway(){
assertNotNull(waitingExecution);
assertEquals(0L,runtimeService.createProcessInstanceQuery().processInstanceId(processInstance.getId()).count());
assertNotNull(historicActivityInstance);
}