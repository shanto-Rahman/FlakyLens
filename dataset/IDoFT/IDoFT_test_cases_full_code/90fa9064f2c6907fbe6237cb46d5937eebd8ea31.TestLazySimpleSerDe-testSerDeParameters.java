/** 
 * Tests the deprecated usage of SerDeParameters.
 */
@Test @SuppressWarnings("deprecation") public void testSerDeParameters() throws SerDeException, IOException {
  LazySimpleSerDe serDe=new LazySimpleSerDe();
  Configuration conf=new Configuration();
  MyTestClass row=new MyTestClass();
  ExtraTypeInfo extraTypeInfo=new ExtraTypeInfo();
  row.randomFill(new Random(1234),extraTypeInfo);
  StructObjectInspector rowOI=(StructObjectInspector)ObjectInspectorFactory.getReflectionObjectInspector(MyTestClass.class,ObjectInspectorOptions.JAVA);
  String fieldNames=ObjectInspectorUtils.getFieldNames(rowOI);
  String fieldTypes=ObjectInspectorUtils.getFieldTypes(rowOI);
  Properties schema=new Properties();
  schema.setProperty(serdeConstants.LIST_COLUMNS,fieldNames);
  schema.setProperty(serdeConstants.LIST_COLUMN_TYPES,fieldTypes);
  SerDeUtils.initializeSerDe(serDe,conf,schema,null);
  SerDeParameters serdeParams=LazySimpleSerDe.initSerdeParams(conf,schema,"testSerdeName");
  LazyStruct data=(LazyStruct)serializeAndDeserialize(row,rowOI,serDe,serdeParams);
  assertEquals((boolean)row.myBool,((LazyBoolean)data.getField(0)).getWritableObject().get());
  assertEquals((int)row.myInt,((LazyInteger)data.getField(3)).getWritableObject().get());
}
