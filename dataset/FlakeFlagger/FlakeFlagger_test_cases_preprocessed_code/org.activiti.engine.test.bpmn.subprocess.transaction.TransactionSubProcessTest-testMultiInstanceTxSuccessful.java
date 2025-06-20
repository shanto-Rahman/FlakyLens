@Deployment(resources={"org/activiti/engine/test/bpmn/subprocess/transaction/TransactionSubProcessTest.testMultiInstanceTx.bpmn20.xml"}) public void testMultiInstanceTxSuccessful(){
assertEquals(10,EventSubscriptionEntitys.size());
assertEquals(0,createEventSubscriptionQuery().count());
}