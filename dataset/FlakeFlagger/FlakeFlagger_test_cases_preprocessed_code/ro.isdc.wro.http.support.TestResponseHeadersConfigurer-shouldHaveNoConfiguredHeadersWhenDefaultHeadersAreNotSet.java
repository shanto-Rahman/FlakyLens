@Test public void shouldHaveNoConfiguredHeadersWhenDefaultHeadersAreNotSet(){
assertTrue(victim.getHeadersMap().entrySet().isEmpty());
}