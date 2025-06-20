@SuppressWarnings("unchecked") @Test public void testThriftSetObjectInspector() throws Throwable {
assertEquals(oi1,oi2);
assertEquals(Category.STRUCT,oi1.getCategory());
assertEquals(2,fields.size());
assertEquals(fields.get(0),soi.getStructFieldRef("sIntString"));
assertEquals(fields.get(1),soi.getStructFieldRef("aString"));
assertNull(soi.getStructFieldData(null,fields.get(i)));
assertEquals(set1,soi.getStructFieldData(s,fields.get(0)));
assertEquals("setString",soi.getStructFieldData(s,fields.get(1)));
assertEquals(ObjectInspectorFactory.getStandardListObjectInspector(ObjectInspectorFactory.getReflectionObjectInspector(IntString.class,ObjectInspectorFactory.ObjectInspectorOptions.THRIFT)),fields.get(0).getFieldObjectInspector());
assertEquals(PrimitiveObjectInspectorFactory.javaStringObjectInspector,fields.get(1).getFieldObjectInspector());
assertEquals(1,loi.getListLength(set1));
assertEquals(1,list.size());
assertEquals(1,s1.getMyint());
assertEquals("test",s1.getMyString());
assertEquals(2,s1.getUnderscore_int());
}