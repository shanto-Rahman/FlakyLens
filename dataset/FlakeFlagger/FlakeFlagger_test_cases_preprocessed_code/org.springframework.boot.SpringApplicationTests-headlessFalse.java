@Test public void headlessFalse() throws Exception {
assertThat(System.getProperty("java.awt.headless"),equalTo("false"));
}