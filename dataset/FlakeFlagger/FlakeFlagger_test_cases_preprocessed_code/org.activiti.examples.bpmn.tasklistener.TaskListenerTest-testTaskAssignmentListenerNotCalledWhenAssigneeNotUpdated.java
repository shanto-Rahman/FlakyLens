@Deployment(resources={"org/activiti/examples/bpmn/tasklistener/TaskListenerTest.bpmn20.xml"}) public void testTaskAssignmentListenerNotCalledWhenAssigneeNotUpdated(){
assertEquals("TaskCreateListener is listening!",task.getDescription());
assertEquals("TaskAssignmentListener is listening: kermit",task.getDescription());
assertEquals("Clear",task.getDescription());
assertEquals("Clear",task.getDescription());
assertEquals("Clear",task.getDescription());
assertEquals("TaskAssignmentListener is listening: john",task.getDescription());
}