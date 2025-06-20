/** 
 * HIVE-5788 <p> Background: in cases of "add column", table metadata changes but data does not.  Columns missing from the data but which are required by metadata are interpreted as null. <p> This tests the use-case of altering columns of a table with already some data, then adding more data in the new schema, and seeing if this serde can to read both types of data from the resultant table.
 * @throws SerDeException
 */
@Test public void testHandlingAlteredSchemas() throws SerDeException {
  StructObjectInspector oi=(StructObjectInspector)ObjectInspectorFactory.getReflectionObjectInspector(BeforeStruct.class,ObjectInspectorOptions.JAVA);
  String cols=ObjectInspectorUtils.getFieldNames(oi);
  Properties props=new Properties();
  props.setProperty(serdeConstants.LIST_COLUMNS,cols);
  props.setProperty(serdeConstants.LIST_COLUMN_TYPES,ObjectInspectorUtils.getFieldTypes(oi));
  LazyBinaryColumnarSerDe serde=new LazyBinaryColumnarSerDe();
  SerDeUtils.initializeSerDe(serde,new Configuration(),props,null);
  BeforeStruct bs1=new BeforeStruct();
  bs1.l1=1L;
  bs1.l2=2L;
  BytesRefArrayWritable braw1=(BytesRefArrayWritable)serde.serialize(bs1,oi);
  oi=(StructObjectInspector)ObjectInspectorFactory.getReflectionObjectInspector(AfterStruct.class,ObjectInspectorOptions.JAVA);
  cols=ObjectInspectorUtils.getFieldNames(oi);
  props=new Properties();
  props.setProperty(serdeConstants.LIST_COLUMNS,cols);
  props.setProperty(serdeConstants.LIST_COLUMN_TYPES,ObjectInspectorUtils.getFieldTypes(oi));
  serde=new LazyBinaryColumnarSerDe();
  SerDeUtils.initializeSerDe(serde,new Configuration(),props,null);
  AfterStruct as=new AfterStruct();
  as.l1=11L;
  as.l2=12L;
  as.l3=13L;
  BytesRefArrayWritable braw2=(BytesRefArrayWritable)serde.serialize(as,oi);
  serde=new LazyBinaryColumnarSerDe();
  SerDeUtils.initializeSerDe(serde,new Configuration(),props,null);
  LazyBinaryColumnarStruct struct1=(LazyBinaryColumnarStruct)serde.deserialize(braw1);
  oi=(StructObjectInspector)serde.getObjectInspector();
  List<Object> objs1=oi.getStructFieldsDataAsList(struct1);
  Assert.assertEquals(((LongWritable)objs1.get(0)).get(),1L);
  Assert.assertEquals(((LongWritable)objs1.get(1)).get(),2L);
  Assert.assertNull(objs1.get(2));
  LazyBinaryColumnarStruct struct2=(LazyBinaryColumnarStruct)serde.deserialize(braw2);
  List<Object> objs2=struct2.getFieldsAsList();
  Assert.assertEquals(((LongWritable)objs2.get(0)).get(),11L);
  Assert.assertEquals(((LongWritable)objs2.get(1)).get(),12L);
  Assert.assertEquals(((LongWritable)objs2.get(2)).get(),13L);
}
