@Test public void testObjectInspectorUtils() throws Throwable {
  try {
    ObjectInspector oi1=ObjectInspectorFactory.getReflectionObjectInspector(Complex.class,ObjectInspectorFactory.ObjectInspectorOptions.THRIFT);
    assertEquals(Category.STRUCT,oi1.getCategory());
    StructObjectInspector soi=(StructObjectInspector)ObjectInspectorUtils.getStandardObjectInspector(oi1);
    List<? extends StructField> fields=soi.getAllStructFieldRefs();
    assertEquals(10,fields.size());
    assertEquals(fields.get(0),soi.getStructFieldRef("aint"));
    for (int i=0; i < fields.size(); i++) {
      assertNull(soi.getStructFieldData(null,fields.get(i)));
    }
    Complex cc=new Complex();
    cc.setAint(1);
    cc.setAString("test");
    List<Integer> c2=Arrays.asList(new Integer[]{1,2,3});
    cc.setLint(c2);
    List<String> c3=Arrays.asList(new String[]{"one","two"});
    cc.setLString(c3);
    List<IntString> c4=new ArrayList<IntString>();
    cc.setLintString(c4);
    cc.setMStringString(null);
    Object c=ObjectInspectorUtils.copyToStandardObject(cc,oi1);
    assertEquals(1,soi.getStructFieldData(c,fields.get(0)));
    assertEquals("test",soi.getStructFieldData(c,fields.get(1)));
    assertEquals(c2,soi.getStructFieldData(c,fields.get(2)));
    assertEquals(c3,soi.getStructFieldData(c,fields.get(3)));
    assertEquals(c4,soi.getStructFieldData(c,fields.get(4)));
    assertNull(soi.getStructFieldData(c,fields.get(5)));
    ArrayList<Object> cfields=new ArrayList<Object>();
    for (int i=0; i < 10; i++) {
      cfields.add(soi.getStructFieldData(c,fields.get(i)));
    }
    assertEquals(cfields,soi.getStructFieldsDataAsList(c));
    assertEquals(PrimitiveObjectInspectorFactory.javaIntObjectInspector,fields.get(0).getFieldObjectInspector());
    assertEquals(PrimitiveObjectInspectorFactory.javaStringObjectInspector,fields.get(1).getFieldObjectInspector());
    assertEquals(ObjectInspectorFactory.getStandardListObjectInspector(PrimitiveObjectInspectorFactory.javaIntObjectInspector),fields.get(2).getFieldObjectInspector());
    assertEquals(ObjectInspectorFactory.getStandardListObjectInspector(PrimitiveObjectInspectorFactory.javaStringObjectInspector),fields.get(3).getFieldObjectInspector());
    assertEquals(ObjectInspectorUtils.getStandardObjectInspector(ObjectInspectorFactory.getStandardListObjectInspector(ObjectInspectorFactory.getReflectionObjectInspector(IntString.class,ObjectInspectorFactory.ObjectInspectorOptions.THRIFT))),fields.get(4).getFieldObjectInspector());
    assertEquals(ObjectInspectorFactory.getStandardMapObjectInspector(PrimitiveObjectInspectorFactory.javaStringObjectInspector,PrimitiveObjectInspectorFactory.javaStringObjectInspector),fields.get(5).getFieldObjectInspector());
  }
 catch (  Throwable e) {
    e.printStackTrace();
    throw e;
  }
}
