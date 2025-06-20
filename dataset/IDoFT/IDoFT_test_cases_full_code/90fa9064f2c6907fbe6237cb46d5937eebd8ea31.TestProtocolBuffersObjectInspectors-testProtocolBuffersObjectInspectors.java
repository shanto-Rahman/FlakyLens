@Test public void testProtocolBuffersObjectInspectors() throws Throwable {
  try {
    ObjectInspector oi1=ObjectInspectorFactory.getReflectionObjectInspector(Complex.class,ObjectInspectorFactory.ObjectInspectorOptions.PROTOCOL_BUFFERS);
    ObjectInspector oi2=ObjectInspectorFactory.getReflectionObjectInspector(Complex.class,ObjectInspectorFactory.ObjectInspectorOptions.PROTOCOL_BUFFERS);
    assertEquals(oi1,oi2);
    assertEquals(Category.STRUCT,oi1.getCategory());
    StructObjectInspector soi=(StructObjectInspector)oi1;
    List<? extends StructField> fields=soi.getAllStructFieldRefs();
    assertEquals(5,fields.size());
    assertEquals(fields.get(0),soi.getStructFieldRef("aint_"));
    for (int i=0; i < fields.size(); i++) {
      assertNull(soi.getStructFieldData(null,fields.get(i)));
    }
    List<Integer> c2=Arrays.asList(new Integer[]{1,2,3});
    List<String> c3=Arrays.asList(new String[]{"one","two"});
    List<IntString> c4=new ArrayList<IntString>();
    Complex c=new Complex(1,"test",c2,c3,c4);
    assertEquals(1,soi.getStructFieldData(c,fields.get(0)));
    assertEquals("test",soi.getStructFieldData(c,fields.get(1)));
    assertEquals(c2,soi.getStructFieldData(c,fields.get(2)));
    assertEquals(c3,soi.getStructFieldData(c,fields.get(3)));
    assertEquals(c4,soi.getStructFieldData(c,fields.get(4)));
    ArrayList<Object> cfields=new ArrayList<Object>();
    for (int i=0; i < 5; i++) {
      cfields.add(soi.getStructFieldData(c,fields.get(i)));
    }
    assertEquals(cfields,soi.getStructFieldsDataAsList(c));
    assertEquals(PrimitiveObjectInspectorFactory.javaIntObjectInspector,fields.get(0).getFieldObjectInspector());
    assertEquals(PrimitiveObjectInspectorFactory.javaStringObjectInspector,fields.get(1).getFieldObjectInspector());
    assertEquals(ObjectInspectorFactory.getStandardListObjectInspector(PrimitiveObjectInspectorFactory.javaIntObjectInspector),fields.get(2).getFieldObjectInspector());
    assertEquals(ObjectInspectorFactory.getStandardListObjectInspector(PrimitiveObjectInspectorFactory.javaStringObjectInspector),fields.get(3).getFieldObjectInspector());
    assertEquals(ObjectInspectorFactory.getStandardListObjectInspector(ObjectInspectorFactory.getReflectionObjectInspector(IntString.class,ObjectInspectorFactory.ObjectInspectorOptions.PROTOCOL_BUFFERS)),fields.get(4).getFieldObjectInspector());
  }
 catch (  Throwable e) {
    e.printStackTrace();
    throw e;
  }
}
