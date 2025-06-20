/** 
 * Test added to validate UUID variable type + querying (ACT-1665)
 */
@Deployment public void testUUIDVariableAndQuery(){
assertNotNull(processInstance);
assertNotNull(task);
assertNotNull(resultingTask);
assertEquals(task.getId(),resultingTask.getId());
assertNotNull(result);
assertEquals(processInstance.getId(),result.getId());
}