@Test public void testGetSystemProperty() throws Exception {
assertThat(ConfigUtils.getSystemProperty("dubbo"),equalTo("system-only"));
}