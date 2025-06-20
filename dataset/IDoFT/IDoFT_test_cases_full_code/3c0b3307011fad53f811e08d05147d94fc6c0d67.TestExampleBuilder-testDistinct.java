@Test public void testDistinct(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Example example=Example.builder(Country.class).distinct().build();
    List<Country> countries=mapper.selectByExample(example);
    Assert.assertEquals(183,countries.size());
    Example example0=Example.builder(Country.class).selectDistinct("id","countryname").build();
    List<Country> countries0=mapper.selectByExample(example0);
    Assert.assertEquals(183,countries0.size());
  }
  finally {
    sqlSession.close();
  }
}
