@Test public void shouldHaveMinimizationTurnedOffWhenMinimizeEnabledIsFalse() throws IOException {
assertEquals(new CacheKey("g1",ResourceType.CSS,false),victim.create(mockRequest));
}