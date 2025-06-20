@Deployment public void testHistoricTaskInstanceQueryProcessFinished(){
assertEquals(1,historyService.createHistoricTaskInstanceQuery().processUnfinished().count());
assertEquals(0,historyService.createHistoricTaskInstanceQuery().processFinished().count());
assertEquals(2,historyService.createHistoricTaskInstanceQuery().processUnfinished().count());
assertEquals(0,historyService.createHistoricTaskInstanceQuery().processFinished().count());
assertEquals(0,historyService.createHistoricTaskInstanceQuery().processUnfinished().count());
assertEquals(2,historyService.createHistoricTaskInstanceQuery().processFinished().count());
}