@Test public void exit() throws Exception {
assertNotNull(context);
assertEquals(0,SpringApplication.exit(context));
}