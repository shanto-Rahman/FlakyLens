@Test public void defaultFlyway() throws Exception {
assertEquals("[classpath:db/migration]",Arrays.asList(flyway.getLocations()).toString());
}