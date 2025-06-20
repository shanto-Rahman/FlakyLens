@Test public void testEnvironment1() throws Exception {
assertThat(application.getEnvironment(),equalTo("develop"));
assertThat(application.getEnvironment(),equalTo("test"));
assertThat(application.getEnvironment(),equalTo("product"));
}