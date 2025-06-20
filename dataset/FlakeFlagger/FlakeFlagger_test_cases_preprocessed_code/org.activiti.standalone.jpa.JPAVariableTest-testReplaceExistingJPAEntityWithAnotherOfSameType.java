@Deployment(resources="org/activiti/standalone/jpa/JPAVariableTest.testQueryJPAVariable.bpmn20.xml") public void testReplaceExistingJPAEntityWithAnotherOfSameType(){
EntityManager manager=entityManagerFactory.createEntityManager();//RW
assertEquals(newVariable.getId(),((FieldAccessJPAEntity)variable).getId());
}