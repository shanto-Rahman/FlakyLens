@Test public void testRcaOnJobtrackerHost() throws AmbariException {
assertEquals("true",cmd.getExecutionCommand().getConfigurations().get("global").get("rca_enabled"));
assertEquals("false",cmd.getExecutionCommand().getConfigurations().get("global").get("rca_enabled"));
}