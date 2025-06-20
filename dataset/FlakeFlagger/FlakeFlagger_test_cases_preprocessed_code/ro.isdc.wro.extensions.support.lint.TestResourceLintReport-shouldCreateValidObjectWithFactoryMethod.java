@Test public void shouldCreateValidObjectWithFactoryMethod(){
assertEquals("path",victim.getResourcePath());
assertEquals(2,victim.getLints().size());
}