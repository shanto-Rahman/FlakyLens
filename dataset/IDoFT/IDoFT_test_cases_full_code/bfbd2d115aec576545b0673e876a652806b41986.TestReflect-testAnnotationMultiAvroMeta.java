@Test public void testAnnotationMultiAvroMeta(){
  check(RAvroMultiMeta.class,"{\"type\":\"record\",\"name\":\"RAvroMultiMeta\",\"namespace\":" + "\"org.apache.avro.reflect.TestReflect\",\"fields\":[" + "{\"name\":\"a\",\"type\":\"int\",\"K\":\"V\",\"L\":\"W\"}]"+ ",\"X\":\"Y\",\"A\":\"B\"}");
}
