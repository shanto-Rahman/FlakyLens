@Deployment public void testNullVariable(){
assertEquals("434",resultVar);
fail("Should throw exception as testProperty is not defined and used in Script task");
assertEquals("class org.activiti.engine.ActivitiException",e.getClass().toString());
fail("Should not throw exception as the testProperty is defined, although null");
assertNull(resultVar);
}