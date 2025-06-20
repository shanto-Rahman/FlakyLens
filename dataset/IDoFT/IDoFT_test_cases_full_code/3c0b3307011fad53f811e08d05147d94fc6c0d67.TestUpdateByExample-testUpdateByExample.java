@Test public void testUpdateByExample(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Example example=new Example(Country.class);
    example.createCriteria().andEqualTo("id",35);
    Country country=new Country();
    country.setCountryname("天朝");
    country.setId(1000);
    int count=mapper.updateByExample(country,example);
    Assert.assertEquals(1,count);
    example=new Example(Country.class);
    example.createCriteria().andIsNull("countrycode");
    count=mapper.selectCountByExample(example);
    Assert.assertEquals(1,count);
  }
  finally {
    sqlSession.rollback();
    sqlSession.close();
  }
}
