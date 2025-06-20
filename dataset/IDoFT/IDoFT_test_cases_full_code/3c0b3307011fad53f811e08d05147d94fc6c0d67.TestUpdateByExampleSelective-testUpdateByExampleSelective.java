@Test public void testUpdateByExampleSelective(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Example example=new Example(Country.class);
    example.createCriteria().andGreaterThan("id",100);
    Country country=new Country();
    country.setCountryname("天朝");
    int count=mapper.updateByExampleSelective(country,example);
    Assert.assertEquals(83,count);
    example=new Example(Country.class);
    example.createCriteria().andEqualTo("countryname","天朝");
    count=mapper.selectCountByExample(example);
    Assert.assertEquals(83,count);
  }
  finally {
    sqlSession.rollback();
    sqlSession.close();
  }
}
