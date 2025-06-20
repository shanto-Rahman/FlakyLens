@Test public void onSamePort() throws Exception {
assertContent("/controller",ports.get().server,"controlleroutput");//RW
assertContent("/endpoint",ports.get().server,"endpointoutput");//RW
assertContent("/controller",ports.get().management,null);//RW
assertContent("/endpoint",ports.get().management,null);//RW
assertTrue(hasHeader("/endpoint",ports.get().server,"X-Application-Context"));//RW
}