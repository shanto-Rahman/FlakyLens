@Test public void specificPortsViaProperties() throws Exception {
EnvironmentTestUtils.addEnvironment(this.applicationContext,"server.port:" + ports.get().server,"management.port:" + ports.get().management);//RW
assertContent("/controller",ports.get().server,"controlleroutput");//RW
assertContent("/endpoint",ports.get().server,null);//RW
assertContent("/controller",ports.get().management,null);//RW
assertContent("/endpoint",ports.get().management,"endpointoutput");//RW
}