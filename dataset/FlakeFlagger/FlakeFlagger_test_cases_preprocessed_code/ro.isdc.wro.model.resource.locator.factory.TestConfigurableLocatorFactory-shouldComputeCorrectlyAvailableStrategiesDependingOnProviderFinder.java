@Test public void shouldComputeCorrectlyAvailableStrategiesDependingOnProviderFinder(){
assertTrue(victim.getAvailableStrategies().isEmpty());
assertEquals(2,victim.getAvailableStrategies().size());
assertEquals("[first, second]",victim.getAvailableAliases().toString());
}