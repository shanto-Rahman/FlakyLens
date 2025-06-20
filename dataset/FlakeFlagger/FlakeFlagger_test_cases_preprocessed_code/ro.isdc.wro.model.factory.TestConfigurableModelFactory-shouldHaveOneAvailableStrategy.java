@Test public void shouldHaveOneAvailableStrategy(){
assertEquals(1,victim.getAvailableStrategies().size());
assertEquals(expectedAliases,victim.getAvailableAliases());
}