@Test public void testStringKeyedMap() throws Exception {
  Schema mapSchema=SchemaBuilder.map(Schema.STRING_SCHEMA,Schema.INT32_SCHEMA).build();
  Map<String,Integer> map=new HashMap<>();
  map.put("One",1);
  map.put("Two",2);
  SinkRecord sinkRecord=new SinkRecord(TOPIC,PARTITION,Schema.STRING_SCHEMA,key,mapSchema,map,0);
  ElasticsearchWriter writer=initWriter(client);
  writeDataAndRefresh(writer,Collections.singletonList(sinkRecord));
  Collection<?> expectedRecords=Collections.singletonList(new ObjectMapper().writeValueAsString(map));
  verifySearchResults(expectedRecords,TOPIC);
}
