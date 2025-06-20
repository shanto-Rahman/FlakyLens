public void test_checkPayload_default8M() throws Exception {
assertThat(expected.getMessage(),allOf(CoreMatchers.containsString("Data length too large: "),CoreMatchers.containsString("max payload: " + 8 * 1024 * 1024)));
}