@Test public void shouldInheritInterfacesOfTheObject(){
assertNotNull(proxy);
assertNotSame(object,proxy);
assertTrue(proxy instanceof MutableResourceAuthorizationManager);
}