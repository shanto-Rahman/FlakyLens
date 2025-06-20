@Deployment(resources={"org/activiti/engine/test/history/oneTaskProcess.bpmn20.xml"}) public void testQueryHistoricTaskIncludeBinaryVariable() throws Exception {
assertNotNull(task);
assertNotNull(historicTask);
assertNotNull(historicTask.getProcessVariables());
assertEquals("It is I, le binary",new String(bytes));
assertNotNull(historicTask);
assertNotNull(historicTask.getTaskLocalVariables());
assertEquals("It is I, le binary",new String(bytes));
}