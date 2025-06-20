@Test public void testSelectCountByExample(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Example example=new Example(Country.class);
    example.setCountProperty("id");
    example.createCriteria().andGreaterThan("id",100);
    int count=mapper.selectCountByExample(example);
    Assert.assertEquals(83,count);
  }
  finally {
    sqlSession.close();
  }
}
