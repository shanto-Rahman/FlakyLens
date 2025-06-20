@Deployment(resources={"org/activiti/standalone/jpa/JPAVariableTest.testStoreJPAEntityAsVariable.bpmn20.xml"}) public void testEnhancedEntityListVariables() throws Exception {
if (FieldAccessJPAEntity.class == fieldEntity.getClass() || PropertyAccessJPAEntity.class == propertyEntity.getClass()) {//RW
}
params.put("list1",Arrays.asList(fieldEntity,fieldEntity));//RW
params.put("list2",Arrays.asList(propertyEntity,propertyEntity));//RW
assertTrue(list.size() == 2);
assertTrue(list.get(0) instanceof FieldAccessJPAEntity);
assertTrue(list.get(1) instanceof FieldAccessJPAEntity);
assertTrue(list.size() == 2);
assertTrue(list.get(0) instanceof PropertyAccessJPAEntity);
assertTrue(list.get(1) instanceof PropertyAccessJPAEntity);
params.putAll(Collections.singletonMap("list",Arrays.asList(fieldEntity,fieldEntity2)));//RW
assertTrue(list.size() == 2);
assertTrue(list.get(0) instanceof FieldAccessJPAEntity);
assertTrue(((FieldAccessJPAEntity)list.get(0)).getId().equals(1L));
assertTrue(list.get(1) instanceof FieldAccessJPAEntity);
assertTrue(((FieldAccessJPAEntity)list.get(1)).getId().equals(2L));
params.putAll(Collections.singletonMap("list",Arrays.asList(fieldEntity2,fieldEntity)));//RW
assertTrue(list.size() == 2);
assertTrue(list.get(0) instanceof FieldAccessJPAEntity);
assertTrue(((FieldAccessJPAEntity)list.get(0)).getId().equals(2L));
assertTrue(list.get(1) instanceof FieldAccessJPAEntity);
assertTrue(((FieldAccessJPAEntity)list.get(1)).getId().equals(1L));
params.put("list",Arrays.asList(fieldEntity,propertyEntity));//RW
fail();
}