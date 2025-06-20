@Test public void shouldCreateProxyForAValidObject(){
assertNotNull(proxy);
assertNotSame(object,proxy);
}