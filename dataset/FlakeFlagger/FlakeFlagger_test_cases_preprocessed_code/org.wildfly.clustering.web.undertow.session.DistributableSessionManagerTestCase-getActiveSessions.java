@Test public void getActiveSessions(){
assertEquals(1,result.size());
assertSame(expected,result.iterator().next());
}