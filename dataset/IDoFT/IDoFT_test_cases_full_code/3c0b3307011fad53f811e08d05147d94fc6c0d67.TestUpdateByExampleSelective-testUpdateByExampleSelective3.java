@Test public void testUpdateByExampleSelective3(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    CountryExample example=new CountryExample();
    example.createCriteria().andCountrynameLike("A%");
    example.or().andIdGreaterThan(100);
    example.setDistinct(true);
    Country country=new Country();
    country.setCountryname("天朝");
    int count=mapper.updateByExampleSelective(country,example);
    Assert.assertEquals(true,count > 83);
    example=new CountryExample();
    example.createCriteria().andCountrynameEqualTo("天朝");
    count=mapper.selectCountByExample(example);
    Assert.assertEquals(true,count > 83);
  }
  finally {
    sqlSession.rollback();
    sqlSession.close();
  }
}
