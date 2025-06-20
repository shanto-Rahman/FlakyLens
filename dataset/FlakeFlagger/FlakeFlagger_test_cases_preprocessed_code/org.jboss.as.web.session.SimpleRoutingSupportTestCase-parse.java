@Test public void parse(){
assertEquals("session1",result.getKey());
assertEquals("route1",result.getValue());
assertEquals("session2",result.getKey());
assertNull(result.getValue());
assertNull(result.getKey());
assertNull(result.getValue());
}