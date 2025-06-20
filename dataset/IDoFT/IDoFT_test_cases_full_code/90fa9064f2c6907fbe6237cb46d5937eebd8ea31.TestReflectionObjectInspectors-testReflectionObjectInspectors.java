@Test public void testReflectionObjectInspectors() throws Throwable {
  try {
    ObjectInspector oi1=ObjectInspectorFactory.getReflectionObjectInspector(MyStruct.class,ObjectInspectorFactory.ObjectInspectorOptions.JAVA);
    ObjectInspector oi2=ObjectInspectorFactory.getReflectionObjectInspector(MyStruct.class,ObjectInspectorFactory.ObjectInspectorOptions.JAVA);
    assertEquals(oi1,oi2);
    assertEquals(Category.STRUCT,oi1.getCategory());
    StructObjectInspector soi=(StructObjectInspector)oi1;
    List<? extends StructField> fields=soi.getAllStructFieldRefs();
    assertEquals(6,fields.size());
    assertEquals(fields.get(2),soi.getStructFieldRef("myString"));
    for (int i=0; i < fields.size(); i++) {
      assertNull(soi.getStructFieldData(null,fields.get(i)));
    }
    assertNull(soi.getStructFieldsDataAsList(null));
    MyStruct a=new MyStruct();
    a.myInt=1;
    a.myInteger=2;
    a.myString="test";
    a.myStruct=a;
    a.myListString=Arrays.asList(new String[]{"a","b","c"});
    a.myMapStringString=new HashMap<String,String>();
    a.myMapStringString.put("key","value");
    assertEquals(1,soi.getStructFieldData(a,fields.get(0)));
    assertEquals(2,soi.getStructFieldData(a,fields.get(1)));
    assertEquals("test",soi.getStructFieldData(a,fields.get(2)));
    assertEquals(a,soi.getStructFieldData(a,fields.get(3)));
    assertEquals(a.myListString,soi.getStructFieldData(a,fields.get(4)));
    assertEquals(a.myMapStringString,soi.getStructFieldData(a,fields.get(5)));
    ArrayList<Object> afields=new ArrayList<Object>();
    for (int i=0; i < 6; i++) {
      afields.add(soi.getStructFieldData(a,fields.get(i)));
    }
    assertEquals(afields,soi.getStructFieldsDataAsList(a));
    assertEquals(PrimitiveObjectInspectorFactory.javaIntObjectInspector,fields.get(0).getFieldObjectInspector());
    assertEquals(PrimitiveObjectInspectorFactory.javaIntObjectInspector,fields.get(1).getFieldObjectInspector());
    assertEquals(PrimitiveObjectInspectorFactory.javaStringObjectInspector,fields.get(2).getFieldObjectInspector());
    assertEquals(soi,fields.get(3).getFieldObjectInspector());
    assertEquals(ObjectInspectorFactory.getStandardListObjectInspector(PrimitiveObjectInspectorFactory.javaStringObjectInspector),fields.get(4).getFieldObjectInspector());
    assertEquals(ObjectInspectorFactory.getStandardMapObjectInspector(PrimitiveObjectInspectorFactory.javaStringObjectInspector,PrimitiveObjectInspectorFactory.javaStringObjectInspector),fields.get(5).getFieldObjectInspector());
  }
 catch (  Throwable e) {
    e.printStackTrace();
    throw e;
  }
}
