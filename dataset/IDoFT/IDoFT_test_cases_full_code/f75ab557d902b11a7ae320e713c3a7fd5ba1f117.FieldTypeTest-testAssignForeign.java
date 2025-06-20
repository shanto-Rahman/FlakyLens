@Test public void testAssignForeign() throws Exception {
  Field[] fields=ForeignParent.class.getDeclaredFields();
  assertTrue(fields.length >= 3);
  Field field=fields[2];
  FieldType fieldType=FieldType.createFieldType(databaseType,ForeignParent.class.getSimpleName(),field,ForeignParent.class);
  fieldType.configDaoInformation(connectionSource,ForeignParent.class);
  assertTrue(fieldType.isForeign());
  int id=10;
  ForeignParent parent=new ForeignParent();
  assertNull(parent.foreign);
  fieldType.assignField(connectionSource,parent,id,false,null);
  ForeignForeign foreign=parent.foreign;
  assertNotNull(foreign);
  assertEquals(id,foreign.id);
  fieldType.assignField(connectionSource,parent,id,false,null);
  assertSame(foreign,parent.foreign);
  int newId=id + 1;
  fieldType.assignField(connectionSource,parent,newId,false,null);
  assertNotSame(foreign,parent.foreign);
  assertEquals(newId,parent.foreign.id);
}
