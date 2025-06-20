@Test public void testName() throws Exception {
assertThat(method.getName(),equalTo("hello"));
assertThat(parameters,not(hasKey("name")));
}