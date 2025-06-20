@Deployment(resources={"org/activiti/engine/test/bpmn/multiinstance/MultiInstanceTest.sequentialUserTasks.bpmn20.xml"}) public void testSequentialUserTasksCompletionCondition(){
assertNull(taskService.createTaskQuery().singleResult());
}