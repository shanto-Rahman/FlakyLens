/** 
 * The test entrance function.
 * @throws Throwable
 */
@Test public void testLazyBinarySerDe() throws Throwable {
  try {
    System.out.println("Beginning Test TestLazyBinarySerDe:");
    int num=1000;
    Random r=new Random(1234);
    MyTestClass rows[]=new MyTestClass[num];
    for (int i=0; i < num; i++) {
      MyTestClass t=new MyTestClass();
      ExtraTypeInfo extraTypeInfo=new ExtraTypeInfo();
      t.randomFill(r,extraTypeInfo);
      rows[i]=t;
    }
    StructObjectInspector rowOI=(StructObjectInspector)ObjectInspectorFactory.getReflectionObjectInspector(MyTestClass.class,ObjectInspectorOptions.JAVA);
    String fieldNames=ObjectInspectorUtils.getFieldNames(rowOI);
    String fieldTypes=ObjectInspectorUtils.getFieldTypes(rowOI);
    testLazyBinarySerDe(rows,rowOI,getSerDe(fieldNames,fieldTypes));
    testLazyBinaryMap(r);
    testShorterSchemaDeserialization(r);
    testLongerSchemaDeserialization(r);
    testShorterSchemaDeserialization1(r);
    testLongerSchemaDeserialization1(r);
    System.out.println("Test TestLazyBinarySerDe passed!");
  }
 catch (  Throwable e) {
    e.printStackTrace();
    throw e;
  }
}
