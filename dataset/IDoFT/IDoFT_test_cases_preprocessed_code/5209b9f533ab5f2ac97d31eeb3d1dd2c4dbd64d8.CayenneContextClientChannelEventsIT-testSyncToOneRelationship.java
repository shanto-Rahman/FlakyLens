@Test public void testSyncToOneRelationship() throws Exception {
assertEquals("g1",o1.getTable1().getGlobalAttribute1());
assertEquals("g1",o2.getTable1().getGlobalAttribute1());
Thread.sleep(500);
assertEquals("g2",o2.getTable1().getGlobalAttribute1());
assertEquals(o1r.getObjectId(),o2.getTable1().getObjectId());
assertFalse(c1.internalGraphManager().hasChanges());
assertFalse(c2.internalGraphManager().hasChanges());
}