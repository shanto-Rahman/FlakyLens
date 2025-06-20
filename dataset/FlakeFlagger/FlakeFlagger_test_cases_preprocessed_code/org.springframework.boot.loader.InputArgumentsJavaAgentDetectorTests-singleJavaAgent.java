@Test public void singleJavaAgent() throws MalformedURLException, IOException {
assertTrue(detector.isJavaAgentJar(new File("my-agent.jar").getCanonicalFile().toURI().toURL()));//RO
}