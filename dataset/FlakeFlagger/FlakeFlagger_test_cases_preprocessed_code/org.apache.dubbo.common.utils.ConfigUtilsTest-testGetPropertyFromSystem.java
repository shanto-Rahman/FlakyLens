@Test public void testGetPropertyFromSystem() throws Exception {
assertThat(ConfigUtils.getProperty("dubbo"),equalTo("system"));
}