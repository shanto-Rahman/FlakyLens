@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testRemoveVariable(){
assertEquals("value1",taskService.getVariable(currentTask.getId(),"variable1"));
assertNull(taskService.getVariableLocal(currentTask.getId(),"variable1"));
assertNull(taskService.getVariable(currentTask.getId(),"variable1"));
}