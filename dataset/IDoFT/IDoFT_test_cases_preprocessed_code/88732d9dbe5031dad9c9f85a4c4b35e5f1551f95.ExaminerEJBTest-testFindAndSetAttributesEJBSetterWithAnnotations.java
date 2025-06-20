@Test public void testFindAndSetAttributesEJBSetterWithAnnotations(){
assertEquals(1,DependencyContainer.getInstance().getDependencies(javaSource).size());
assertEquals(DependencyType.EJB,dependency.getDependencyType());
assertEquals("ZeiterfassungEingabeModel",dependency.getJavaSourceFrom().getName());
assertEquals("Date",dependency.getJavaSourceTo().getName());
}