@Test public void testClone() throws Exception {
assertEquals(clone.getDescription(),monitor.getDescription());
assertEquals(clone.getState(),monitor.getState());
assertEquals(clone.getStatus(),monitor.getStatus());
assertEquals(clone.toString(),monitor.toString());
assertEquals(clone.toMap(),monitor.toMap());
assertEquals(clone.toJSON(),monitor.toJSON());
testParam.setParam("dirtyParam");//IT
assertEquals(clone.getDescription(),monitor.getDescription());
fail("Should not call toMap successfully, because param=null");
}