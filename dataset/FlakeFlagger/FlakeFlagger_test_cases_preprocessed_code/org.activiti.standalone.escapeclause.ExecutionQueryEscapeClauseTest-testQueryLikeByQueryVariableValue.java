@Test public void testQueryLikeByQueryVariableValue(){
assertNotNull(execution);
assertEquals(processInstance1.getId(),execution.getId());
assertNotNull(execution);
assertEquals(processInstance2.getId(),execution.getId());
}