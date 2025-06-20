@Deployment(resources={"org/activiti/engine/test/api/task/TaskQueryTest.testProcessDefinition.bpmn20.xml"}) public void testTaskDueBeforeOr() throws Exception {
assertEquals(1,taskService.createTaskQuery().processInstanceId(processInstance.getId()).or().taskId("invalid").taskDueBefore(oneHourLater.getTime()).count());
assertEquals(0,taskService.createTaskQuery().processInstanceId(processInstance.getId()).or().taskId("invalid").taskDueBefore(oneHourAgo.getTime()).count());
assertEquals(0,taskService.createTaskQuery().processInstanceId(processInstance.getId()).or().taskId("invalid").taskDueBefore(oneHourLater.getTime()).count());
assertEquals(0,taskService.createTaskQuery().processInstanceId(processInstance.getId()).or().taskId("invalid").taskDueBefore(oneHourAgo.getTime()).count());
}