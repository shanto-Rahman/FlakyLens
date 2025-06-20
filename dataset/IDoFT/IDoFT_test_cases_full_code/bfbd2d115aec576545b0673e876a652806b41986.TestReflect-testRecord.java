@Test public void testRecord() throws Exception {
  check(R.class,"{\"type\":\"record\",\"name\":\"R\",\"namespace\":" + "\"org.apache.avro.reflect.TestReflect\",\"fields\":[" + "{\"name\":\"a\",\"type\":\"int\"},"+ "{\"name\":\"b\",\"type\":\"long\"}]}");
}
