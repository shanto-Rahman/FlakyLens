@Deployment(resources={"org/activiti/engine/test/bpmn/multiinstance/MultiInstanceTest.sequentialUserTasks.bpmn20.xml"}) public void testSequentialUserTasksWithTimer(){
assertEquals("taskAfterTimer",taskAfterTimer.getTaskDefinitionKey());
}