@Test @CmmnDeployment(resources={"org/flowable/cmmn/test/runtime/CaseTaskTest.terminateAvailableCaseTask.cmmn","org/flowable/cmmn/test/runtime/oneHumanTaskCase.cmmn"}) public void testTerminateAvailableCaseTask(){
assertEquals("myCase",planItemInstance.getName());
}