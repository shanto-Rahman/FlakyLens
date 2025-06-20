@Test public void testFindMethodByMethodSignature() throws Exception {
assertEquals("method1",m.getName());
assertEquals(1,parameterTypes.length);
assertEquals(int.class,parameterTypes[0]);
}