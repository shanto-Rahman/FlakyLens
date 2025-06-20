/** 
 * TestCase to reproduce Issue ACT-1344
 */
@Deployment public void testNonInterruptingSignalWithSubProcess(){
assertEquals(1,tasks.size());
assertEquals("Approve",currentTask.getName());
assertEquals(2,tasks.size());
if (!task.getName().equals("Approve") && !task.getName().equals("Review")) {
fail("Expected: <Approve> or <Review> but was <" + task.getName() + ">.");
}
assertEquals(1,tasks.size());
assertEquals("Review",currentTask.getName());
assertEquals(1,tasks.size());
}