@Test public void testBetween(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Example example=Example.builder(Country.class).where(Sqls.custom().andBetween("id",34,35)).build();
    List<Country> countries=mapper.selectByExample(example);
    Country country35=countries.get(0);
    Assert.assertEquals(Integer.valueOf(35),country35.getId());
    Assert.assertEquals("China",country35.getCountryname());
    Assert.assertEquals("CN",country35.getCountrycode());
    Country country34=countries.get(1);
    Assert.assertEquals(Integer.valueOf(34),country34.getId());
    Assert.assertEquals("Chile",country34.getCountryname());
    Assert.assertEquals("CL",country34.getCountrycode());
  }
  finally {
    sqlSession.close();
  }
}
