@Test public void testUserSpecifiedConfigName() throws Exception {
assertEquals("my.Application",launcher.getMainClass());
assertEquals("[etc/]",ReflectionTestUtils.getField(launcher,"paths").toString());
}