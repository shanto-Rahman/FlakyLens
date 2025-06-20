@Test public void testFindAndSetAttributesSetInstance(){
assertEquals(1,DependencyContainer.getInstance().getDependencies(javaSource).size());
assertEquals(DependencyType.INSTANCE,dependency.getDependencyType());
assertEquals("EscalationNotificationBroker",dependency.getJavaSourceFrom().getName());
assertEquals("Transmitter",dependency.getJavaSourceTo().getName());
}