@Test public void testUserSpecifiedWildcardPath() throws Exception {
assertEquals("[jars/]",ReflectionTestUtils.getField(launcher,"paths").toString());
}