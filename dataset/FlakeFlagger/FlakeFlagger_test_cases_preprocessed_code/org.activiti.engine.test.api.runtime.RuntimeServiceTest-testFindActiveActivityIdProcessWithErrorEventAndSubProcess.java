/** 
 * Testcase to reproduce ACT-950 (https://jira.codehaus.org/browse/ACT-950)
 */
@Deployment public void testFindActiveActivityIdProcessWithErrorEventAndSubProcess(){
assertEquals(5,activeActivities.size());
assertEquals(2,tasks.size());
if (!task.getName().equals("ParallelUserTask") && !task.getName().equals("MainUserTask")) {
fail("Expected: <ParallelUserTask> or <MainUserTask> but was <" + task.getName() + ">.");
}
if (task.getName().equals("ParallelUserTask")) {
}
assertNotNull(parallelUserTask);
assertEquals(4,activeActivities.size());
assertEquals(2,tasks.size());
if (!task.getName().equals("BeforeError") && !task.getName().equals("MainUserTask")) {
fail("Expected: <BeforeError> or <MainUserTask> but was <" + task.getName() + ">.");
}
if (task.getName().equals("BeforeError")) {
}
assertNotNull(beforeErrorUserTask);
assertEquals(2,activeActivities.size());
assertEquals(2,tasks.size());
if (!task.getName().equals("AfterError") && !task.getName().equals("MainUserTask")) {
fail("Expected: <AfterError> or <MainUserTask> but was <" + task.getName() + ">.");
}
if (task.getName().equals("AfterError")) {
}
assertNotNull(afterErrorUserTask);
assertEquals(1,tasks.size());
assertEquals("MainUserTask",tasks.get(0).getName());
assertEquals(1,activeActivities.size());
assertEquals("MainUserTask",activeActivities.get(0));
}