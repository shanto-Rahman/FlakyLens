@Test @LocalData public void testFormatDidNotChange() throws Exception {
assertThat(previousConfig).isNotNull();
assertThat(previousConfig).isNotEmpty();
assertThat(previousConfig).withFailMessage(message).isXmlEqualTo(currentConfig);
}