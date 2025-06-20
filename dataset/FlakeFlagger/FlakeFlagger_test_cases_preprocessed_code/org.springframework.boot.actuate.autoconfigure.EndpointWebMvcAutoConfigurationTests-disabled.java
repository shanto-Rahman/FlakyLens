@Test public void disabled() throws Exception {
assertContent("/controller",ports.get().server,"controlleroutput");//RW
assertContent("/endpoint",ports.get().server,null);//RW
assertContent("/controller",ports.get().management,null);//RW
assertContent("/endpoint",ports.get().management,null);//RW
}