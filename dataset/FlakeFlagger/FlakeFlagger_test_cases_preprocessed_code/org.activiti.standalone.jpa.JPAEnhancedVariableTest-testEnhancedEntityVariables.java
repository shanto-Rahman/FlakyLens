@Deployment(resources={"org/activiti/standalone/jpa/JPAVariableTest.testStoreJPAEntityAsVariable.bpmn20.xml"}) public void testEnhancedEntityVariables() throws Exception {
if (FieldAccessJPAEntity.class == fieldEntity.getClass() || PropertyAccessJPAEntity.class == propertyEntity.getClass()) {//RW
}
params.put("fieldEntity",fieldEntity);//RW
params.put("propertyEntity",propertyEntity);//RW
if (name.equals("fieldEntity")) {
assertTrue(value instanceof FieldAccessJPAEntity);
if (name.equals("propertyEntity")) {
assertTrue(value instanceof PropertyAccessJPAEntity);
fail();
}
}
}