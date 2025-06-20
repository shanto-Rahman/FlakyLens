@Deployment public void testDelegateExpressionListenerFieldInjection(){
assertEquals(2,variables.size());
assertEquals(4200,((Number)variables.get("processStartValue")).intValue());
assertEquals(3,variables.size());
assertEquals(420000,((Number)variables.get("sequenceFlowValue")).intValue());
assertEquals(4,variables.size());
assertEquals(210000,((Number)variables.get("taskCreateValue")).intValue());
assertEquals(5,variables.size());
assertEquals(105000,((Number)variables.get("taskCompleteValue")).intValue());
assertEquals(1,TestExecutionListener.INSTANCE_COUNT.get());
assertEquals(1,TestTaskListener.INSTANCE_COUNT.get());
}