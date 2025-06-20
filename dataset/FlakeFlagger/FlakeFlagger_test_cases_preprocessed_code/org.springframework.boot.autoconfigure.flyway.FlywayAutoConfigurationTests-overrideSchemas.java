@Test public void overrideSchemas() throws Exception {
assertEquals("[public]",Arrays.asList(flyway.getSchemas()).toString());
}