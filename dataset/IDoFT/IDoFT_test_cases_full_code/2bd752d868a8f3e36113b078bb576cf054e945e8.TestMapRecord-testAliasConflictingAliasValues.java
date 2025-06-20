@Test public void testAliasConflictingAliasValues(){
  final List<RecordField> fields=new ArrayList<>();
  fields.add(new RecordField("foo",RecordFieldType.STRING.getDataType(),null,set("bar","baz")));
  final RecordSchema schema=new SimpleRecordSchema(fields);
  final Map<String,Object> values=new HashMap<>();
  values.put("baz",1);
  values.put("bar",33);
  final Record record=new MapRecord(schema,values);
  assertEquals(33,record.getValue("foo"));
  assertEquals(33,record.getValue("bar"));
  assertEquals(33,record.getValue("baz"));
}
