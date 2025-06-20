@SuppressWarnings("unchecked") @Test public void testThriftSetObjectInspector() throws Throwable {
  try {
    ObjectInspector oi1=ObjectInspectorFactory.getReflectionObjectInspector(SetIntString.class,ObjectInspectorFactory.ObjectInspectorOptions.THRIFT);
    ObjectInspector oi2=ObjectInspectorFactory.getReflectionObjectInspector(SetIntString.class,ObjectInspectorFactory.ObjectInspectorOptions.THRIFT);
    assertEquals(oi1,oi2);
    assertEquals(Category.STRUCT,oi1.getCategory());
    StructObjectInspector soi=(StructObjectInspector)oi1;
    List<? extends StructField> fields=soi.getAllStructFieldRefs();
    assertEquals(2,fields.size());
    assertEquals(fields.get(0),soi.getStructFieldRef("sIntString"));
    assertEquals(fields.get(1),soi.getStructFieldRef("aString"));
    for (int i=0; i < fields.size(); i++) {
      assertNull(soi.getStructFieldData(null,fields.get(i)));
    }
    IntString s1=new IntString();
    s1.setMyint(1);
    s1.setMyString("test");
    s1.setUnderscore_int(2);
    Set<IntString> set1=new HashSet<IntString>();
    set1.add(s1);
    SetIntString s=new SetIntString();
    s.setSIntString(set1);
    s.setAString("setString");
    assertEquals(set1,soi.getStructFieldData(s,fields.get(0)));
    assertEquals("setString",soi.getStructFieldData(s,fields.get(1)));
    assertEquals(ObjectInspectorFactory.getStandardListObjectInspector(ObjectInspectorFactory.getReflectionObjectInspector(IntString.class,ObjectInspectorFactory.ObjectInspectorOptions.THRIFT)),fields.get(0).getFieldObjectInspector());
    assertEquals(PrimitiveObjectInspectorFactory.javaStringObjectInspector,fields.get(1).getFieldObjectInspector());
    ListObjectInspector loi=(ListObjectInspector)fields.get(0).getFieldObjectInspector();
    assertEquals(1,loi.getListLength(set1));
    List<IntString> list=(List<IntString>)loi.getList(set1);
    assertEquals(1,list.size());
    s1=(IntString)loi.getListElement(list,0);
    assertEquals(1,s1.getMyint());
    assertEquals("test",s1.getMyString());
    assertEquals(2,s1.getUnderscore_int());
  }
 catch (  Throwable e) {
    e.printStackTrace();
    throw e;
  }
}
