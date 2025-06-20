@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testDeleteTaskPartOfProcess(){
assertNotNull(task);
assertEquals("The task cannot be deleted because is part of a running process",ae.getMessage());
assertEquals("The task cannot be deleted because is part of a running process",ae.getMessage());
assertEquals("The task cannot be deleted because is part of a running process",ae.getMessage());
assertEquals("The task cannot be deleted because is part of a running process",ae.getMessage());
assertEquals("The task cannot be deleted because is part of a running process",ae.getMessage());
assertEquals("The task cannot be deleted because is part of a running process",ae.getMessage());
}