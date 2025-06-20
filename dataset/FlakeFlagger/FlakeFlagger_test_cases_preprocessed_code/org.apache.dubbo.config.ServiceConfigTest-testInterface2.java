@Test public void testInterface2() throws Exception {
assertThat(service.getInterface(),equalTo(DemoService.class.getName()));
}