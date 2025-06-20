@Test public void nonAgentJarsDoNotProduceFalsePositives() throws MalformedURLException, IOException {
assertFalse(detector.isJavaAgentJar(new File("something-else.jar").getCanonicalFile().toURI().toURL()));//RO
}