@Test public void testInterfaceClass() throws Exception {
assertThat(service.getInterfaceClass() == Greeting.class,is(true));
assertThat(service.getInterfaceClass() == GenericService.class,is(true));
}