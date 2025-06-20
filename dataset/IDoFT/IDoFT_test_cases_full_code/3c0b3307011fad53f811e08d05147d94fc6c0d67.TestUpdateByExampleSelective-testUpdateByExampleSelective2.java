@Test public void testUpdateByExampleSelective2(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Example example=new Example(Country.class);
    example.createCriteria().andLike("countryname","A%");
    example.or().andGreaterThan("id",100);
    example.setDistinct(true);
    Country country=new Country();
    country.setCountryname("天朝");
    int count=mapper.updateByExampleSelective(country,example);
    Assert.assertEquals(true,count > 83);
    example=new Example(Country.class);
    example.createCriteria().andEqualTo("countryname","天朝");
    count=mapper.selectCountByExample(example);
    Assert.assertEquals(true,count > 83);
  }
  finally {
    sqlSession.rollback();
    sqlSession.close();
  }
}
