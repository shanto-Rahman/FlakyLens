@Test public void onRandomPort() throws Exception {
assertThat(managementPort,not(equalTo(ports.get().server)));//RW
assertContent("/controller",ports.get().server,"controlleroutput");//RW
assertContent("/endpoint",ports.get().server,null);//RW
}