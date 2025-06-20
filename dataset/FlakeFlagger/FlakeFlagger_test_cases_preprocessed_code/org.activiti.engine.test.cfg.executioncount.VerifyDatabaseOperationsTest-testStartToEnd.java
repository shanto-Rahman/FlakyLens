public void testStartToEnd(){
Assert.assertEquals(0,runtimeService.createProcessInstanceQuery().count());
Assert.assertEquals(1,historyService.createHistoricProcessInstanceQuery().finished().count());
}