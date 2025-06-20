public void testMessageBoundaryEvent(){
assertEquals(1,getAllEventSubscriptions().size());
assertEquals(2,getAllEventSubscriptions().size());
assertEquals(2,tasks.size());
assertEquals("Task after message",task.getName());
}