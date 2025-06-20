@Test public void testEqualTo(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Example example=Example.builder(Country.class).where(Sqls.custom().andEqualTo("id","35")).build();
    List<Country> countries=mapper.selectByExample(example);
    Country country=countries.get(0);
    Assert.assertEquals(Integer.valueOf(35),country.getId());
    Assert.assertEquals("China",country.getCountryname());
    Assert.assertEquals("CN",country.getCountrycode());
  }
  finally {
    sqlSession.close();
  }
}
