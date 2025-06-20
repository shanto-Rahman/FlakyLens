@Test public void shouldRenderToJson(){
  Map<String,DocumentField> fields=new LinkedHashMap<>();
  fields.put("string",new DocumentField("string",Collections.singletonList("value")));
  fields.put("bool",new DocumentField("bool",Arrays.asList(true,true,false)));
  SearchHit searchHit=new SearchHit(123,"my-id",new Text("type"),fields,null);
  SearchDocument document=DocumentAdapters.from(searchHit);
  assertThat(document.toJson()).isEqualTo("{\"string\":\"value\",\"bool\":[true,true,false]}");
}
