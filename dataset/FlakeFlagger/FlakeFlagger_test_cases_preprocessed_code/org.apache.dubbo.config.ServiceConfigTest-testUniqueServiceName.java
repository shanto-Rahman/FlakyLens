@Test public void testUniqueServiceName() throws Exception {
assertThat(service.getUniqueServiceName(),equalTo("dubbo/" + Greeting.class.getName() + ":1.0.0"));
}