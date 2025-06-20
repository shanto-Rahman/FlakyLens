@Test public void testThriftObjectInspectors() throws Throwable {
  try {
    ObjectInspector oi1=ObjectInspectorFactory.getReflectionObjectInspector(Complex.class,ObjectInspectorFactory.ObjectInspectorOptions.THRIFT);
    ObjectInspector oi2=ObjectInspectorFactory.getReflectionObjectInspector(Complex.class,ObjectInspectorFactory.ObjectInspectorOptions.THRIFT);
    assertEquals(oi1,oi2);
    assertEquals(Category.STRUCT,oi1.getCategory());
    StructObjectInspector soi=(StructObjectInspector)oi1;
    List<? extends StructField> fields=soi.getAllStructFieldRefs();
    assertEquals(10,fields.size());
    assertEquals(fields.get(0),soi.getStructFieldRef("aint"));
    for (int i=0; i < fields.size(); i++) {
      assertNull(soi.getStructFieldData(null,fields.get(i)));
    }
    ObjectInspector oi=ObjectInspectorFactory.getReflectionObjectInspector(PropValueUnion.class,ObjectInspectorFactory.ObjectInspectorOptions.THRIFT);
    assertNotNull(oi.toString());
    Complex c=new Complex();
    c.setAint(1);
    c.setAString("test");
    List<Integer> c2=Arrays.asList(new Integer[]{1,2,3});
    c.setLint(c2);
    List<String> c3=Arrays.asList(new String[]{"one","two"});
    c.setLString(c3);
    List<IntString> c4=new ArrayList<IntString>();
    c.setLintString(c4);
    c.setMStringString(null);
    c.setAttributes(null);
    c.setUnionField1(null);
    c.setUnionField2(null);
    c.setUnionField3(null);
    assertEquals(1,soi.getStructFieldData(c,fields.get(0)));
    assertEquals("test",soi.getStructFieldData(c,fields.get(1)));
    assertEquals(c2,soi.getStructFieldData(c,fields.get(2)));
    assertEquals(c3,soi.getStructFieldData(c,fields.get(3)));
    assertEquals(c4,soi.getStructFieldData(c,fields.get(4)));
    assertNull(soi.getStructFieldData(c,fields.get(5)));
    assertNull(soi.getStructFieldData(c,fields.get(6)));
    assertNull(soi.getStructFieldData(c,fields.get(7)));
    assertNull(soi.getStructFieldData(c,fields.get(8)));
    assertNull(soi.getStructFieldData(c,fields.get(9)));
    ArrayList<Object> cfields=new ArrayList<Object>();
    for (int i=0; i < 10; i++) {
      cfields.add(soi.getStructFieldData(c,fields.get(i)));
    }
    assertEquals(cfields,soi.getStructFieldsDataAsList(c));
    assertEquals(PrimitiveObjectInspectorFactory.javaIntObjectInspector,fields.get(0).getFieldObjectInspector());
    assertEquals(PrimitiveObjectInspectorFactory.javaStringObjectInspector,fields.get(1).getFieldObjectInspector());
    assertEquals(ObjectInspectorFactory.getStandardListObjectInspector(PrimitiveObjectInspectorFactory.javaIntObjectInspector),fields.get(2).getFieldObjectInspector());
    assertEquals(ObjectInspectorFactory.getStandardListObjectInspector(PrimitiveObjectInspectorFactory.javaStringObjectInspector),fields.get(3).getFieldObjectInspector());
    assertEquals(ObjectInspectorFactory.getStandardListObjectInspector(ObjectInspectorFactory.getReflectionObjectInspector(IntString.class,ObjectInspectorFactory.ObjectInspectorOptions.THRIFT)),fields.get(4).getFieldObjectInspector());
    assertEquals(ObjectInspectorFactory.getStandardMapObjectInspector(PrimitiveObjectInspectorFactory.javaStringObjectInspector,PrimitiveObjectInspectorFactory.javaStringObjectInspector),fields.get(5).getFieldObjectInspector());
  }
 catch (  Throwable e) {
    e.printStackTrace();
    throw e;
  }
}
