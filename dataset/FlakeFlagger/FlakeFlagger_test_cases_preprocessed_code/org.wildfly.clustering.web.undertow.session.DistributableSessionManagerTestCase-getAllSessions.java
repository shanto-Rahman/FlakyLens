@Test public void getAllSessions(){
assertEquals(1,result.size());
assertSame(expected,result.iterator().next());
}