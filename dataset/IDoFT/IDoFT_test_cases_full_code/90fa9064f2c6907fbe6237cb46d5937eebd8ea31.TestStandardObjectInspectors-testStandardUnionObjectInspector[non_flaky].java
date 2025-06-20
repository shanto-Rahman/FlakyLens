@SuppressWarnings("unchecked") @Test public void testStandardUnionObjectInspector() throws Throwable {
  try {
    ArrayList<ObjectInspector> objectInspectors=new ArrayList<ObjectInspector>();
    objectInspectors.add(PrimitiveObjectInspectorFactory.javaIntObjectInspector);
    objectInspectors.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
    objectInspectors.add(PrimitiveObjectInspectorFactory.javaBooleanObjectInspector);
    objectInspectors.add(ObjectInspectorFactory.getStandardListObjectInspector(PrimitiveObjectInspectorFactory.javaIntObjectInspector));
    objectInspectors.add(ObjectInspectorFactory.getStandardMapObjectInspector(PrimitiveObjectInspectorFactory.javaIntObjectInspector,PrimitiveObjectInspectorFactory.javaStringObjectInspector));
    List<String> fieldNames=new ArrayList<String>();
    fieldNames.add("myDouble");
    fieldNames.add("myLong");
    ArrayList<ObjectInspector> fieldObjectInspectors=new ArrayList<ObjectInspector>();
    fieldObjectInspectors.add(PrimitiveObjectInspectorFactory.javaDoubleObjectInspector);
    fieldObjectInspectors.add(PrimitiveObjectInspectorFactory.javaLongObjectInspector);
    objectInspectors.add(ObjectInspectorFactory.getStandardStructObjectInspector(fieldNames,fieldObjectInspectors));
    StandardUnionObjectInspector uoi1=ObjectInspectorFactory.getStandardUnionObjectInspector(objectInspectors);
    StandardUnionObjectInspector uoi2=ObjectInspectorFactory.getStandardUnionObjectInspector((ArrayList<ObjectInspector>)objectInspectors.clone());
    assertEquals(uoi1,uoi2);
    assertEquals(ObjectInspectorUtils.getObjectInspectorName(uoi1),ObjectInspectorUtils.getObjectInspectorName(uoi2));
    assertTrue(ObjectInspectorUtils.compareTypes(uoi1,uoi2));
    assertFalse(ObjectInspectorUtils.compareSupported(uoi1));
    ArrayList<ObjectInspector> ois=(ArrayList<ObjectInspector>)objectInspectors.clone();
    ois.set(4,PrimitiveObjectInspectorFactory.javaIntObjectInspector);
    assertTrue(ObjectInspectorUtils.compareSupported(ObjectInspectorFactory.getStandardUnionObjectInspector(ois)));
    assertEquals(Category.UNION,uoi1.getCategory());
    List<? extends ObjectInspector> uois=uoi1.getObjectInspectors();
    assertEquals(6,uois.size());
    for (int i=0; i < 6; i++) {
      assertEquals(objectInspectors.get(i),uois.get(i));
    }
    StringBuilder unionTypeName=new StringBuilder();
    unionTypeName.append("uniontype<");
    for (int i=0; i < uois.size(); i++) {
      if (i > 0) {
        unionTypeName.append(",");
      }
      unionTypeName.append(uois.get(i).getTypeName());
    }
    unionTypeName.append(">");
    assertEquals(unionTypeName.toString(),uoi1.getTypeName());
    TypeInfo typeInfo1=TypeInfoUtils.getTypeInfoFromObjectInspector(uoi1);
    assertEquals(Category.UNION,typeInfo1.getCategory());
    assertEquals(UnionTypeInfo.class.getName(),typeInfo1.getClass().getName());
    assertEquals(typeInfo1.getTypeName(),uoi1.getTypeName());
    assertEquals(typeInfo1,TypeInfoUtils.getTypeInfoFromTypeString(uoi1.getTypeName()));
    TypeInfo typeInfo2=TypeInfoUtils.getTypeInfoFromObjectInspector(uoi2);
    assertEquals(typeInfo1,typeInfo2);
    assertEquals(TypeInfoUtils.getStandardJavaObjectInspectorFromTypeInfo(typeInfo1),TypeInfoUtils.getStandardJavaObjectInspectorFromTypeInfo(typeInfo2));
    assertEquals(TypeInfoUtils.getStandardWritableObjectInspectorFromTypeInfo(typeInfo1),TypeInfoUtils.getStandardWritableObjectInspectorFromTypeInfo(typeInfo2));
    assertNull(uoi1.getField(null));
    assertEquals(-1,uoi1.getTag(null));
    UnionObject union=new StandardUnion((byte)0,1);
    assertEquals(0,uoi1.getTag(union));
    assertEquals(1,uoi1.getField(union));
    assertEquals("{0:1}",SerDeUtils.getJSONString(union,uoi1));
    assertEquals(0,ObjectInspectorUtils.compare(union,uoi1,new StandardUnion((byte)0,1),uoi2));
    assertTrue(ObjectInspectorUtils.copyToStandardObject(union,uoi1).equals(1));
    union=new StandardUnion((byte)1,"two");
    assertEquals(1,uoi1.getTag(union));
    assertEquals("two",uoi1.getField(union));
    assertEquals("{1:\"two\"}",SerDeUtils.getJSONString(union,uoi1));
    assertEquals(0,ObjectInspectorUtils.compare(union,uoi1,new StandardUnion((byte)1,"two"),uoi2));
    assertTrue(ObjectInspectorUtils.copyToStandardObject(union,uoi1).equals("two"));
    union=new StandardUnion((byte)2,true);
    assertEquals(2,uoi1.getTag(union));
    assertEquals(true,uoi1.getField(union));
    assertEquals("{2:true}",SerDeUtils.getJSONString(union,uoi1));
    assertEquals(0,ObjectInspectorUtils.compare(union,uoi1,new StandardUnion((byte)2,true),uoi2));
    assertTrue(ObjectInspectorUtils.copyToStandardObject(union,uoi1).equals(true));
    ArrayList<Integer> iList=new ArrayList<Integer>();
    iList.add(4);
    iList.add(5);
    union=new StandardUnion((byte)3,iList);
    assertEquals(3,uoi1.getTag(union));
    assertEquals(iList,uoi1.getField(union));
    assertEquals("{3:[4,5]}",SerDeUtils.getJSONString(union,uoi1));
    assertEquals(0,ObjectInspectorUtils.compare(union,uoi1,new StandardUnion((byte)3,iList.clone()),uoi2));
    assertTrue(ObjectInspectorUtils.copyToStandardObject(union,uoi1).equals(iList));
    HashMap<Integer,String> map=new LinkedHashMap<Integer,String>();
    map.put(6,"six");
    map.put(7,"seven");
    map.put(8,"eight");
    union=new StandardUnion((byte)4,map);
    assertEquals(4,uoi1.getTag(union));
    assertEquals(map,uoi1.getField(union));
    assertEquals("{4:{6:\"six\",7:\"seven\",8:\"eight\"}}",SerDeUtils.getJSONString(union,uoi1));
    Throwable th=null;
    try {
      ObjectInspectorUtils.compare(union,uoi1,new StandardUnion((byte)4,map.clone()),uoi2,null);
    }
 catch (    Throwable t) {
      th=t;
    }
    assertNotNull(th);
    assertEquals("Compare on map type not supported!",th.getMessage());
    assertTrue(ObjectInspectorUtils.copyToStandardObject(union,uoi1).equals(map));
    ArrayList<Object> struct=new ArrayList<Object>(2);
    struct.add(9.0);
    struct.add(10L);
    union=new StandardUnion((byte)5,struct);
    assertEquals(5,uoi1.getTag(union));
    assertEquals(struct,uoi1.getField(union));
    assertEquals("{5:{\"mydouble\":9.0,\"mylong\":10}}",SerDeUtils.getJSONString(union,uoi1));
    assertEquals(0,ObjectInspectorUtils.compare(union,uoi1,new StandardUnion((byte)5,struct.clone()),uoi2));
    assertTrue(ObjectInspectorUtils.copyToStandardObject(union,uoi1).equals(struct));
  }
 catch (  Throwable e) {
    e.printStackTrace();
    throw e;
  }
}
