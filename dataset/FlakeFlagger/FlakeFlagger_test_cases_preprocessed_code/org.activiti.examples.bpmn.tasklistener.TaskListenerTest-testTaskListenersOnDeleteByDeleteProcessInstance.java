@Deployment(resources={"org/activiti/examples/bpmn/tasklistener/TaskListenerTest.testTaskListenersOnDelete.bpmn20.xml"}) public void testTaskListenersOnDeleteByDeleteProcessInstance(){
assertNotNull(tasks);
assertEquals(1,tasks.size());
assertNotNull(task);
assertEquals(0,TaskDeleteListener.getCurrentMessages().size());
assertEquals(0,TaskSimpleCompleteListener.getCurrentMessages().size());
assertNotNull(tasks);
assertEquals(0,tasks.size());
assertEquals(1,TaskDeleteListener.getCurrentMessages().size());
assertEquals("Delete Task Listener executed.",TaskDeleteListener.getCurrentMessages().get(0));
assertEquals(0,TaskSimpleCompleteListener.getCurrentMessages().size());
}