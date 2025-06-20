@Test public void javaAgentJarsAreExcludedFromClasspath() throws Exception {
URL javaAgent=new File("my-agent.jar").getCanonicalFile().toURI().toURL();//RO
}