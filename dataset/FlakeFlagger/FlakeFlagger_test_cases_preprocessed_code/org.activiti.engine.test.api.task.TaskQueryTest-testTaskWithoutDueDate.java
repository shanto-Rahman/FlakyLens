@Deployment(resources={"org/activiti/engine/test/api/task/TaskQueryTest.testProcessDefinition.bpmn20.xml"}) public void testTaskWithoutDueDate() throws Exception {
assertEquals(0,taskService.createTaskQuery().processInstanceId(processInstance.getId()).withoutTaskDueDate().count());
assertEquals(1,taskService.createTaskQuery().processInstanceId(processInstance.getId()).withoutTaskDueDate().count());
}