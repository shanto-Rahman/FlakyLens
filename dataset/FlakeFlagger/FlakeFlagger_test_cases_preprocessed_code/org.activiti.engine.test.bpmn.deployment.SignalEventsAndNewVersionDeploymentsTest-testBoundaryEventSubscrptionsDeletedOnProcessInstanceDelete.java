/** 
 * Verifying that the event subscriptions do get removed when removing a process instance.
 */
public void testBoundaryEventSubscrptionsDeletedOnProcessInstanceDelete(){
assertEquals("My Task",taskService.createTaskQuery().singleResult().getName());
assertEquals(2,taskService.createTaskQuery().count());
assertEquals(2,getAllEventSubscriptions().size());
assertEquals("My Task",taskService.createTaskQuery().singleResult().getName());
assertEquals(1,getAllEventSubscriptions().size());
assertEquals(0,getAllEventSubscriptions().size());
assertEquals("Task after signal",taskService.createTaskQuery().singleResult().getName());
}