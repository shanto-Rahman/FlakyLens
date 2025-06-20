@Test public void multipleJavaAgents() throws MalformedURLException, IOException {
assertTrue(detector.isJavaAgentJar(new File("my-agent.jar").getCanonicalFile().toURI().toURL()));//RO
assertTrue(detector.isJavaAgentJar(new File("my-other-agent.jar").getCanonicalFile().toURI().toURL()));//RO
}