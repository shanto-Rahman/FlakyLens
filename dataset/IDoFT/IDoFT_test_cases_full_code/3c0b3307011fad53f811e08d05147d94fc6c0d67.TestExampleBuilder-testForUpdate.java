@Test public void testForUpdate(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Example example=Example.builder(Country.class).select("countryname").where(Sqls.custom().andGreaterThan("id",100)).orderByAsc("countrycode").forUpdate().build();
    List<Country> countries=mapper.selectByExample(example);
    Assert.assertEquals(83,countries.size());
  }
  finally {
    sqlSession.close();
  }
}
