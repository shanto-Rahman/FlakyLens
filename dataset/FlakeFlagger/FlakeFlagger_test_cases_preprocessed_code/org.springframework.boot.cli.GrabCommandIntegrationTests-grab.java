@Test public void grab() throws Exception {
assertTrue(new File("target/repository/joda-time/joda-time").isDirectory());//RO
assertTrue(output.contains("Downloading: file:"));
}