@Test public void testUserSpecifiedDotPath() throws Exception {
assertEquals("[.]",ReflectionTestUtils.getField(launcher,"paths").toString());
}