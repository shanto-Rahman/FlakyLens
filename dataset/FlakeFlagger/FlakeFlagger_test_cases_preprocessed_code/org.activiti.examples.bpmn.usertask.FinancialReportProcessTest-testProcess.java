@Deployment(resources={"org/activiti/examples/bpmn/usertask/FinancialReportProcess.bpmn20.xml"}) public void testProcess(){
assertEquals(1,tasks.size());
assertEquals("Write monthly financial report",task.getName());
assertEquals(1,tasks.size());
assertEquals(0,tasks.size());
assertEquals(1,tasks.size());
assertEquals("Verify monthly financial report",tasks.get(0).getName());
}