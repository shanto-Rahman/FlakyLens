@Test public void testUserSpecifiedJarPathWithDot() throws Exception {
assertEquals("[jars/app.jar]",ReflectionTestUtils.getField(launcher,"paths").toString());
}