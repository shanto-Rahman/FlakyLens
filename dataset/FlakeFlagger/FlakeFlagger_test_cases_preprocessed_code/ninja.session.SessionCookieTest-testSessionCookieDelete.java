@Test public void testSessionCookieDelete(){
assertEquals(value,sessionCookie.get(key));
assertEquals(value,sessionCookie.remove(key));
assertNull(sessionCookie.get(key));
}