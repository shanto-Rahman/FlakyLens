@Deployment(resources={"org/activiti/examples/bpmn/tasklistener/TaskListenerTest.bpmn20.xml"}) public void testTaskCreateListener(){
assertEquals("Schedule meeting",task.getName());
assertEquals("TaskCreateListener is listening!",task.getDescription());
}