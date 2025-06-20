@Test public void testUpdateByExample2(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Country country=new Country();
    country.setCountryname("天朝");
    country.setId(1000);
    CountryExample example=new CountryExample();
    example.createCriteria().andIdEqualTo(35);
    int count=mapper.updateByExample(country,example);
    Assert.assertEquals(1,count);
    example=new CountryExample();
    example.createCriteria().andCountrycodeIsNull();
    count=mapper.selectCountByExample(example);
    Assert.assertEquals(1,count);
  }
  finally {
    sqlSession.rollback();
    sqlSession.close();
  }
}
