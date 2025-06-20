@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testRemoveVariablesLocal(){
assertEquals("value1",taskService.getVariable(currentTask.getId(),"variable1"));
assertEquals("value2",taskService.getVariable(currentTask.getId(),"variable2"));
assertEquals("value3",taskService.getVariable(currentTask.getId(),"variable3"));
assertEquals("value1",taskService.getVariableLocal(currentTask.getId(),"variable1"));
assertEquals("value2",taskService.getVariableLocal(currentTask.getId(),"variable2"));
assertEquals("value3",taskService.getVariableLocal(currentTask.getId(),"variable3"));
assertNull(taskService.getVariable(currentTask.getId(),"variable1"));
assertNull(taskService.getVariable(currentTask.getId(),"variable2"));
assertEquals("value3",taskService.getVariable(currentTask.getId(),"variable3"));
assertNull(taskService.getVariableLocal(currentTask.getId(),"variable1"));
assertNull(taskService.getVariableLocal(currentTask.getId(),"variable2"));
assertEquals("value3",taskService.getVariableLocal(currentTask.getId(),"variable3"));
}