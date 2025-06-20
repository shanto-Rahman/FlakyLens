public void testQueryByMessageSubscription(){
assertEquals(1,repositoryService.createProcessDefinitionQuery().messageEventSubscriptionName("newInvoiceMessage").count());
assertEquals(1,repositoryService.createProcessDefinitionQuery().messageEventSubscriptionName("newBookingMessage").count());
assertEquals(0,repositoryService.createProcessDefinitionQuery().messageEventSubscriptionName("bogus").count());
}