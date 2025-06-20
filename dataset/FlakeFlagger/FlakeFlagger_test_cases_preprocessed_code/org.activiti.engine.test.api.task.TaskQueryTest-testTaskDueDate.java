@Deployment(resources={"org/activiti/engine/test/api/task/TaskQueryTest.testProcessDefinition.bpmn20.xml"}) public void testTaskDueDate() throws Exception {
assertEquals(1,taskService.createTaskQuery().processInstanceId(processInstance.getId()).taskDueDate(dueDate).count());
assertEquals(0,taskService.createTaskQuery().processInstanceId(processInstance.getId()).taskDueDate(otherDate.getTime()).count());
assertEquals(1,taskService.createTaskQuery().processInstanceId(processInstance.getId()).taskDueAfter(priorDate.getTime()).count());
assertEquals(1,taskService.createTaskQuery().processInstanceId(processInstance.getId()).taskDueBefore(otherDate.getTime()).count());
}