@Test public void capacityLimited(){
assertEquals(2,traces.size());
assertEquals("bar",traces.get(1).getInfo().get("bar"));
}