@Test public void testExcludeColumnsByExample(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Example example=new Example(Country.class);
    example.createCriteria().andGreaterThan("id",100).andLessThan("id",151);
    example.or().andLessThan("id",41);
    example.excludeProperties("id");
    List<Country> countries=mapper.selectByExample(example);
    Assert.assertEquals(90,countries.size());
  }
  finally {
    sqlSession.close();
  }
}
