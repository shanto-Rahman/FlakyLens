@Test public void testOrderBy(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Example example=new Example(Country.class);
    example.orderBy("id").desc().orderBy("countryname").orderBy("countrycode").asc();
    List<Country> countries=mapper.selectByExample(example);
    Assert.assertEquals(183,(int)countries.get(0).getId());
  }
  finally {
    sqlSession.close();
  }
}
