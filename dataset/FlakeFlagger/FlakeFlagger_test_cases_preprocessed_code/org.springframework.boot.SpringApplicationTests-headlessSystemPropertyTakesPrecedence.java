@Test public void headlessSystemPropertyTakesPrecedence() throws Exception {
assertThat(System.getProperty("java.awt.headless"),equalTo("false"));
}