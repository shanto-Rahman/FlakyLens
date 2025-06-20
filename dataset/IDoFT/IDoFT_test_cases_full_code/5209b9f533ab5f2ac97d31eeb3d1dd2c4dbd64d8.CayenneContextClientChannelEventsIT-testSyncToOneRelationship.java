@Test public void testSyncToOneRelationship() throws Exception {
  tMtTable1.insert(1,"g1","s1");
  tMtTable1.insert(2,"g2","s2");
  tMtTable2.insert(1,1,"g1");
  CayenneContext c1=(CayenneContext)runtime.newContext();
  CayenneContext c2=(CayenneContext)runtime.newContext();
  ClientMtTable2 o1=(ClientMtTable2)Cayenne.objectForQuery(c1,new ObjectIdQuery(ObjectId.of("MtTable2","TABLE2_ID",1)));
  ClientMtTable2 o2=(ClientMtTable2)Cayenne.objectForQuery(c2,new ObjectIdQuery(ObjectId.of("MtTable2","TABLE2_ID",1)));
  assertEquals("g1",o1.getTable1().getGlobalAttribute1());
  assertEquals("g1",o2.getTable1().getGlobalAttribute1());
  ClientMtTable1 o1r=(ClientMtTable1)Cayenne.objectForQuery(c1,new ObjectIdQuery(ObjectId.of("MtTable1","TABLE1_ID",2)));
  o1.setTable1(o1r);
  c1.commitChanges();
  Thread.sleep(500);
  assertEquals("g2",o2.getTable1().getGlobalAttribute1());
  assertEquals(o1r.getObjectId(),o2.getTable1().getObjectId());
  assertFalse(c1.internalGraphManager().hasChanges());
  assertFalse(c2.internalGraphManager().hasChanges());
}
