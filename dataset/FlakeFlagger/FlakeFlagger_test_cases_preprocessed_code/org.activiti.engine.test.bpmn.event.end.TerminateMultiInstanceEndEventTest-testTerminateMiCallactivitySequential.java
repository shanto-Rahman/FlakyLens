@Deployment(resources={"org/activiti/engine/test/bpmn/event/end/TerminateMultiInstanceEndEventTest.testTerminateMiCallactivity-parentProcessSequential.bpmn20.xml","org/activiti/engine/test/bpmn/event/end/TerminateMultiInstanceEndEventTest.testTerminateMiCallactivity-calledProcess.bpmn20.xml"}) public void testTerminateMiCallactivitySequential(){
assertEquals("A",taskA.getName());
assertEquals(1,bTasks.size());
assertEquals(1,cTasks.size());
assertEquals(1,dTasks.size());
assertEquals(2,afterMiTasks.size());
assertEquals("AfterMi",afterMiTasks.get(0).getName());
assertEquals("Parallel task",afterMiTasks.get(1).getName());
}