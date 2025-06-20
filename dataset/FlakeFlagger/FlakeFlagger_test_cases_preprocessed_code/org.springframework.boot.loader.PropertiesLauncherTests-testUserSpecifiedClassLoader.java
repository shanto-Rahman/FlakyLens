@Test public void testUserSpecifiedClassLoader() throws Exception {
assertEquals("[jars/app.jar]",ReflectionTestUtils.getField(launcher,"paths").toString());
}