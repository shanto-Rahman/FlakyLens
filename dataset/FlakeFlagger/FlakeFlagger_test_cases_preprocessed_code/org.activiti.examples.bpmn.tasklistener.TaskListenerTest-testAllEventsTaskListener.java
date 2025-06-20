@Deployment(resources={"org/activiti/examples/bpmn/tasklistener/TaskListenerTest.bpmn20.xml"}) public void testAllEventsTaskListener(){
assertEquals("create - assignment - complete - delete",eventsReceived);
}