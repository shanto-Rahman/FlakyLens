@Deployment(resources={"org/activiti/engine/test/history/oneTaskProcess.bpmn20.xml"}) public void testQueryHistoricProcessInstanceIncludeBinaryVariable() throws Exception {
assertNotNull(task);
assertNotNull(historicProcess);
assertNotNull(historicProcess.getProcessVariables());
assertEquals("It is I, le binary",new String(bytes));
}