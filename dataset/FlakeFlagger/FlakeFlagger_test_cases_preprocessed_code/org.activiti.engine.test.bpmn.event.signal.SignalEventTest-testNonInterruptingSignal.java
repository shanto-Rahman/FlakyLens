/** 
 * TestCase to reproduce Issue ACT-1344
 */
@Deployment public void testNonInterruptingSignal(){
assertEquals(1,tasks.size());
assertEquals("My User Task",currentTask.getName());
assertEquals(2,tasks.size());
if (!task.getName().equals("My User Task") && !task.getName().equals("My Second User Task")) {
fail("Expected: <My User Task> or <My Second User Task> but was <" + task.getName() + ">.");
}
assertEquals(1,tasks.size());
assertEquals("My Second User Task",currentTask.getName());
}