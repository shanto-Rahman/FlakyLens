@Test public void testUserSpecifiedJarPath() throws Exception {
assertEquals("[jars/app.jar]",ReflectionTestUtils.getField(launcher,"paths").toString());
}