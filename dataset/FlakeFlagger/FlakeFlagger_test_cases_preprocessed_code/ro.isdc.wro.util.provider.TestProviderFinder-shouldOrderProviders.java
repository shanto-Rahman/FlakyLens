@Test public void shouldOrderProviders(){
if (providerClass == Object.class) {
}
assertEquals(Arrays.asList(lowest,defaultPriority,highest),victim.find());
}