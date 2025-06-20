@Deployment(resources={"org/activiti/engine/test/bpmn/multiinstance/MultiInstanceTest.testParallelSubProcessAllAutomatic.bpmn20.xml"}) public void testParallelSubProcessAllAutomaticCompletionCondition(){
assertTrue(waitSubExecutions.size() > 0);
assertEquals(0,waitSubExecutions.size());
assertEquals(12,runtimeService.getVariable(procId,"sum"));
}