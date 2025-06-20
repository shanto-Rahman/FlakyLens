@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testRemoveVariableLocal(){
assertEquals("value1",taskService.getVariable(currentTask.getId(),"variable1"));
assertEquals("value1",taskService.getVariableLocal(currentTask.getId(),"variable1"));
assertNull(taskService.getVariable(currentTask.getId(),"variable1"));
assertNull(taskService.getVariableLocal(currentTask.getId(),"variable1"));
}