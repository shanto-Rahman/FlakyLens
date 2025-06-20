@Deployment(resources={"org/activiti/standalone/jpa/JPAVariableTest.testQueryJPAVariable.bpmn20.xml"}) public void testReadJpaVariableValueFromHistoricVariableUpdate(){
assertEquals(1,variableUpdates.size());
assertNotNull(update.getValue());
assertTrue(update.getValue() instanceof FieldAccessJPAEntity);
assertEquals(entity.getId(),((FieldAccessJPAEntity)update.getValue()).getId());
}