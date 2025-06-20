@Deployment(resources={"org/activiti/engine/test/api/task/TaskQueryTest.testProcessDefinition.bpmn20.xml"}) public void testTaskDueDateOr() throws Exception {
assertEquals(1,taskService.createTaskQuery().processInstanceId(processInstance.getId()).or().taskId("invalid").taskDueDate(dueDate).count());
assertEquals(0,taskService.createTaskQuery().processInstanceId(processInstance.getId()).or().taskId("invalid").taskDueDate(otherDate.getTime()).count());
assertEquals(1,taskService.createTaskQuery().processInstanceId(processInstance.getId()).or().taskId("invalid").taskDueAfter(priorDate.getTime()).count());
assertEquals(1,taskService.createTaskQuery().processInstanceId(processInstance.getId()).taskDueBefore(otherDate.getTime()).count());
}