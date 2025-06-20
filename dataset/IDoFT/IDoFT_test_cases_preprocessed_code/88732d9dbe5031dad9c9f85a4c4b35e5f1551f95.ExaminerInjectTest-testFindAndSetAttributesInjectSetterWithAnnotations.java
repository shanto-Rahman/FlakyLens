@Test public void testFindAndSetAttributesInjectSetterWithAnnotations(){
assertEquals(1,DependencyContainer.getInstance().getDependencies(javaSource).size());
assertEquals(DependencyType.INJECT,dependency.getDependencyType());
assertEquals("ZeiterfassungEingabeModel",dependency.getJavaSourceFrom().getName());
assertEquals("Date",dependency.getJavaSourceTo().getName());
}