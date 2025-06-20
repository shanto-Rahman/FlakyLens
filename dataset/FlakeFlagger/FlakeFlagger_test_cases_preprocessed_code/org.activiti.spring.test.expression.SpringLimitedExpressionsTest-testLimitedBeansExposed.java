@Deployment public void testLimitedBeansExposed() throws Exception {
assertNotNull(beanOutput);
assertEquals("Activiti BPMN 2.0 process engine",beanOutput);
assertNotNull(task);
fail("Exception should have been thrown");
}