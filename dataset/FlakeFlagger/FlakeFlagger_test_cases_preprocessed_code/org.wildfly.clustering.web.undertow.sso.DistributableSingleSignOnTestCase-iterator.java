@Test public void iterator(){
assertTrue(results.hasNext());
assertEquals(session.getId(),result.getId());
assertFalse(results.hasNext());
}