/** 
 * Test for ACT-1216: When merging a concurrent execution the parent is not activated correctly
 */
@Deployment public void testParentActivationOnNonJoiningEnd() throws Exception {
assertEquals(3,executionsBefore.size());
assertEquals(2,firstTasks.size());
assertEquals(2,secondTasks.size());
assertEquals(2,executionsAfter.size());
if (e.getParentId() != null) {
}
assertEquals(1,activeActivityIds.size());
assertEquals(0l,runtimeService.createProcessInstanceQuery().active().count());
}