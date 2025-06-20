@Test public void testAndExample(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Example example=new Example(Country.class);
    example.createCriteria().andCondition("countryname like 'C%' and id < 100").andCondition("length(countryname) = ",5);
    List<Country> countries=mapper.selectByExample(example);
    Assert.assertEquals(3,countries.size());
  }
  finally {
    sqlSession.close();
  }
}
