@Deployment public void testParseNamespaceInConditionExpressionType(){
assertNotNull(process);
assertEquals("#{approved}",sequenceFlow.getConditionExpression());
assertEquals("#{!approved}",sequenceFlow.getConditionExpression());
}