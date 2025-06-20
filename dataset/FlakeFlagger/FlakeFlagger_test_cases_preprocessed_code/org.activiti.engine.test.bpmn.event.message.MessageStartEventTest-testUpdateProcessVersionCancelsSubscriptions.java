public void testUpdateProcessVersionCancelsSubscriptions(){
assertEquals(1,eventSubscriptions.size());
assertEquals(1,processDefinitions.size());
assertEquals(1,newEventSubscriptions.size());
assertEquals(2,newProcessDefinitions.size());
if (processDefinition.getVersion() == 1) {
assertFalse(subscription.getConfiguration().equals(processDefinition.getId()));
assertTrue(subscription.getConfiguration().equals(processDefinition.getId()));
}
assertFalse(eventSubscriptions.equals(newEventSubscriptions));
}