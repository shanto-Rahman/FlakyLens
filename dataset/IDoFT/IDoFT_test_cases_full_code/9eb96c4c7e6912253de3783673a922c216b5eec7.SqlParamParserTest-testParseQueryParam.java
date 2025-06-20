@Test public void testParseQueryParam(){
  Map<String,Object> queryParam=new LinkedHashMap<>();
  queryParam.put("name","张三");
  queryParam.put("name$like$or","王五");
  queryParam.put("and",TestQueryEntity.builder().name$like("李四%").age$gt(1).or(TestQueryEntity.builder().name$like("王五").age$gt(10).build()).build());
  QueryParamEntity entity=SqlParamParser.parseQueryParam(queryParam);
  Assert.assertTrue(!entity.getTerms().isEmpty());
  Assert.assertEquals(entity.getTerms().get(0).getColumn(),"name");
  Assert.assertEquals(entity.getTerms().get(0).getType(),Term.Type.and);
  Assert.assertEquals(entity.getTerms().get(1).getColumn(),"name");
  Assert.assertEquals(entity.getTerms().get(1).getTermType(),"like");
  Assert.assertEquals(entity.getTerms().get(1).getType(),Term.Type.or);
  Assert.assertEquals(entity.getTerms().get(2).getType(),Term.Type.and);
  Assert.assertTrue(!entity.getTerms().get(2).getTerms().isEmpty());
  Assert.assertEquals(entity.getTerms().get(2).getTerms().get(0).getTermType(),"like");
  Assert.assertEquals(entity.getTerms().get(2).getTerms().get(1).getTermType(),"gt");
  Assert.assertTrue(!entity.getTerms().get(2).getTerms().get(2).getTerms().isEmpty());
  Assert.assertEquals(entity.getTerms().get(2).getTerms().get(2).getTerms().get(0).getTermType(),"like");
  Assert.assertEquals(entity.getTerms().get(2).getTerms().get(2).getTerms().get(1).getTermType(),"gt");
  System.out.println(JSON.toJSONString(entity,SerializerFeature.PrettyFormat));
}
