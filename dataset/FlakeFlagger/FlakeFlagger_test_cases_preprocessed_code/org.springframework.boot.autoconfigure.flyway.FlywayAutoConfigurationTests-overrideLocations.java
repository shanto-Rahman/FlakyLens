@Test public void overrideLocations() throws Exception {
assertEquals("[classpath:db/changelog, classpath:db/migration]",Arrays.asList(flyway.getLocations()).toString());
}