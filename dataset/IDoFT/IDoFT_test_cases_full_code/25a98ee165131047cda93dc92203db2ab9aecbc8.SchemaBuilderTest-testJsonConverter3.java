@Test public void testJsonConverter3(){
  Map<String,String> props=new HashMap<>();
  props.put(JsonFormatConstant.MAX_POINT_NUMBER,"3");
  Schema schema=new Schema();
  Map<String,IMeasurementSchema> template=new HashMap<>();
  template.put("s4",new UnaryMeasurementSchema("s4",TSDataType.DOUBLE,TSEncoding.RLE,CompressionType.SNAPPY,props));
  template.put("s5",new UnaryMeasurementSchema("s5",TSDataType.INT32,TSEncoding.TS_2DIFF,CompressionType.UNCOMPRESSED,null));
  schema.registerSchemaTemplate("template1",template);
  schema.extendTemplate("template1",new UnaryMeasurementSchema("s6",TSDataType.INT64,TSEncoding.RLE,CompressionType.SNAPPY,props));
  schema.registerDevice("d1","template1");
  Collection<IMeasurementSchema> timeseries=schema.getRegisteredTimeseriesMap().values();
  String[] tsDesStrings={"[s4,DOUBLE,RLE,{max_point_number=3},SNAPPY]","[s5,INT32,TS_2DIFF,,UNCOMPRESSED]","[s6,INT64,RLE,{max_point_number=3},SNAPPY]"};
  int i=0;
  for (  IMeasurementSchema desc : timeseries) {
    assertEquals(tsDesStrings[i++],desc.toString());
  }
}
