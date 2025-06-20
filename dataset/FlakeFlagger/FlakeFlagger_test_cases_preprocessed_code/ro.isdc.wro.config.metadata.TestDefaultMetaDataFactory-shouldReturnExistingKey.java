@Test public void shouldReturnExistingKey(){
assertEquals(map,victim.create());
assertEquals("value",victim.create().get("key"));
}