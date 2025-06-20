@Test public void testCreateValidEmailFromString() throws Exception {
assertEquals("the.user@me.com",tuple.x);
assertEquals("The user",tuple.y);
assertEquals("email@me.com",tuple.x);
assertEquals(null,tuple.y);
}