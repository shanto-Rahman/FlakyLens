@Test public void shouldOverrideAvailableLocator(){
assertEquals(1,locators.size());
assertSame(mockUriLocator,iterator.next());
}