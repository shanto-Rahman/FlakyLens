@Test public void initializersCreatedOnce() throws Exception {
assertEquals(2,application.application().getInitializers().size());
}