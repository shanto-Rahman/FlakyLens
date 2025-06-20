@Test @org.activiti.engine.test.Deployment public void testConditionsWithoutExclusiveGateway(){
assertNotNull(processInstance);
assertFalse(processInstance.isEnded());
assertEquals(3,tasks.size());
assertEquals("A",tasks.get(0).getName());
assertEquals("B",tasks.get(1).getName());
assertEquals("C",tasks.get(2).getName());
assertEquals(2,tasks.size());
assertEquals("B",tasks.get(0).getName());
assertEquals("C",tasks.get(1).getName());
assertEquals(1,tasks.size());
assertEquals("C",tasks.get(0).getName());
}