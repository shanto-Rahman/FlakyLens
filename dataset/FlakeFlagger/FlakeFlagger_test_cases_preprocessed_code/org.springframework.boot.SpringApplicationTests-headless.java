@Test public void headless() throws Exception {
assertThat(System.getProperty("java.awt.headless"),equalTo("true"));
}