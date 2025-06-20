@Deployment public void testPartialMergingInclusiveGateway(){
assertEquals("partialTask",partialTask.getTaskDefinitionKey());
assertEquals("theTask",fullTask.getTaskDefinitionKey());
}