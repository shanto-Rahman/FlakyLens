@Test public void testMap() throws Exception {
  Schema structSchema=SchemaBuilder.struct().name("struct").field("map",SchemaBuilder.map(Schema.INT32_SCHEMA,Schema.STRING_SCHEMA).build()).build();
  Map<Integer,String> map=new HashMap<>();
  map.put(1,"One");
  map.put(2,"Two");
  Struct struct=new Struct(structSchema);
  struct.put("map",map);
  Collection<SinkRecord> records=new ArrayList<>();
  SinkRecord sinkRecord=new SinkRecord(TOPIC,PARTITION,Schema.STRING_SCHEMA,key,structSchema,struct,0);
  records.add(sinkRecord);
  ElasticsearchWriter writer=initWriter(client);
  writeDataAndRefresh(writer,records);
  verifySearchResults(records);
}
