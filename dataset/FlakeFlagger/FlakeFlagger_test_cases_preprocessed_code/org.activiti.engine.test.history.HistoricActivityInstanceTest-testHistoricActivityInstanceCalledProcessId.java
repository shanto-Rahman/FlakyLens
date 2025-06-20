@Deployment(resources={"org/activiti/engine/test/history/calledProcess.bpmn20.xml","org/activiti/engine/test/history/HistoricActivityInstanceTest.testCallSimpleSubProcess.bpmn20.xml"}) public void testHistoricActivityInstanceCalledProcessId(){
assertEquals(oldInstance.getId(),historicActivityInstance.getCalledProcessInstanceId());
}