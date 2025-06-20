@Deployment(resources={"org/activiti/engine/test/api/twoTasksProcess.bpmn20.xml"}) public void testCompleteWithParametersTask2(){
assertEquals("First task",task.getName());
assertEquals("Second task",task.getName());
assertEquals(1,variables.size());
assertEquals("myValue",variables.get("myParam"));
}