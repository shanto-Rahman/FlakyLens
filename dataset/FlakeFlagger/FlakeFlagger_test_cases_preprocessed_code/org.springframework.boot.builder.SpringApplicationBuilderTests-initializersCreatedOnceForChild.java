@Test public void initializersCreatedOnceForChild() throws Exception {
assertEquals(3,application.application().getInitializers().size());
}