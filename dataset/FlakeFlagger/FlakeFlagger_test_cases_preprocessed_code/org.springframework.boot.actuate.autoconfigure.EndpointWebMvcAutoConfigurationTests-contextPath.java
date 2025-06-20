@Test public void contextPath() throws Exception {
assertContent("/controller",ports.get().server,"controlleroutput");//RW
assertContent("/test/endpoint",ports.get().server,"endpointoutput");//RW
}