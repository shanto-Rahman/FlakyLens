@Deployment(resources={"org/activiti/engine/test/api/twoTasksProcess.bpmn20.xml"}) public void testResolveWithParametersTask(){
assertEquals("First task",task.getName());
assertEquals("First task",task.getName());
assertEquals(1,variables.size());
assertEquals("myValue",variables.get("myParam"));
}