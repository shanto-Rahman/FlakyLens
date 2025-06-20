@Deployment(resources={"org/activiti/engine/test/api/task/TaskQueryTest.testProcessDefinition.bpmn20.xml"}) public void testTaskDueAfter() throws Exception {
assertEquals(1,taskService.createTaskQuery().processInstanceId(processInstance.getId()).taskDueAfter(oneHourAgo.getTime()).count());
assertEquals(0,taskService.createTaskQuery().processInstanceId(processInstance.getId()).taskDueAfter(oneHourLater.getTime()).count());
assertEquals(0,taskService.createTaskQuery().processInstanceId(processInstance.getId()).taskDueAfter(oneHourLater.getTime()).count());
assertEquals(0,taskService.createTaskQuery().processInstanceId(processInstance.getId()).taskDueAfter(oneHourAgo.getTime()).count());
}