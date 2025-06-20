@Deployment(resources={"org/activiti/examples/bpmn/tasklistener/TaskListenerTest.bpmn20.xml"}) public void testTaskAssignmentListener(){
assertEquals("TaskCreateListener is listening!",task.getDescription());
assertEquals("TaskAssignmentListener is listening: kermit",task.getDescription());
}