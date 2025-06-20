@Test public void testKeyValueSchemaInfoToString() throws JSONException {
  String havePrimitiveType=DefaultImplementation.convertKeyValueSchemaInfoDataToString(KeyValueSchemaInfo.decodeKeyValueSchemaInfo(Schema.KeyValue(Schema.AVRO(Foo.class),Schema.STRING).getSchemaInfo()));
  JSONSchemaTest.assertJSONEqual(havePrimitiveType,KEY_VALUE_SCHEMA_INFO_INCLUDE_PRIMITIVE);
  String notHavePrimitiveType=DefaultImplementation.convertKeyValueSchemaInfoDataToString(KeyValueSchemaInfo.decodeKeyValueSchemaInfo(Schema.KeyValue(Schema.AVRO(Foo.class),Schema.AVRO(Foo.class)).getSchemaInfo()));
  JSONSchemaTest.assertJSONEqual(notHavePrimitiveType,KEY_VALUE_SCHEMA_INFO_NOT_INCLUDE_PRIMITIVE);
}
