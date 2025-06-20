@Deployment(resources={"org/activiti/examples/bpmn/tasklistener/TaskListenerInSubProcessTest.bpmn20.xml"}) public void testTaskCreateListenerInSubProcess(){
assertEquals("Schedule meeting",task.getName());
assertEquals("TaskCreateListener is listening!",task.getDescription());
}