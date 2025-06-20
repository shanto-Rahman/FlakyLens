@Test public void testProtocolBuffersObjectInspectors() throws Throwable {
assertEquals(oi1,oi2);
assertEquals(Category.STRUCT,oi1.getCategory());
assertEquals(5,fields.size());
assertEquals(fields.get(0),soi.getStructFieldRef("aint_"));
assertNull(soi.getStructFieldData(null,fields.get(i)));
assertEquals(1,soi.getStructFieldData(c,fields.get(0)));
assertEquals("test",soi.getStructFieldData(c,fields.get(1)));
assertEquals(c2,soi.getStructFieldData(c,fields.get(2)));
assertEquals(c3,soi.getStructFieldData(c,fields.get(3)));
assertEquals(c4,soi.getStructFieldData(c,fields.get(4)));
assertEquals(cfields,soi.getStructFieldsDataAsList(c));
assertEquals(PrimitiveObjectInspectorFactory.javaIntObjectInspector,fields.get(0).getFieldObjectInspector());
assertEquals(PrimitiveObjectInspectorFactory.javaStringObjectInspector,fields.get(1).getFieldObjectInspector());
assertEquals(ObjectInspectorFactory.getStandardListObjectInspector(PrimitiveObjectInspectorFactory.javaIntObjectInspector),fields.get(2).getFieldObjectInspector());
assertEquals(ObjectInspectorFactory.getStandardListObjectInspector(PrimitiveObjectInspectorFactory.javaStringObjectInspector),fields.get(3).getFieldObjectInspector());
assertEquals(ObjectInspectorFactory.getStandardListObjectInspector(ObjectInspectorFactory.getReflectionObjectInspector(IntString.class,ObjectInspectorFactory.ObjectInspectorOptions.PROTOCOL_BUFFERS)),fields.get(4).getFieldObjectInspector());
}