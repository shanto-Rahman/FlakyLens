/** 
 * This test the isReachable() check that is done to check if upstream tokens can reach the inclusive gateway. In case of loops, special care needs to be taken in the algorithm, or else stackoverflows will happen very quickly.
 */
@Deployment public void testLoop(){
assertEquals("task C",task.getName());
assertEquals(0,taskService.createTaskQuery().count());
assertEquals("Found executions: " + runtimeService.createExecutionQuery().list(),0,runtimeService.createExecutionQuery().count());
}