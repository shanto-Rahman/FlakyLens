@Test void shouldSettersWithUnrelatedArgTypesThrowException() throws Exception {
assertTrue(setableProps.contains("prop1"));
assertTrue(setableProps.contains("prop2"));
assertEquals("prop1",reflector.findPropertyName("PROP1"));
assertEquals("prop2",reflector.findPropertyName("PROP2"));
assertEquals(String.class,reflector.getSetterType("prop1"));
assertNotNull(reflector.getSetInvoker("prop1"));
assertTrue(String.class.equals(paramType) || Integer.class.equals(paramType));
}