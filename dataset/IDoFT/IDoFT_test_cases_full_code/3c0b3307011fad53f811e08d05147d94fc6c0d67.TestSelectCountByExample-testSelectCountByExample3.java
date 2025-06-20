@Test public void testSelectCountByExample3(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    CountryExample example=new CountryExample();
    example.createCriteria().andCountrynameLike("A%");
    example.or().andIdGreaterThan(100);
    example.setDistinct(true);
    int count=mapper.selectCountByExample(example);
    Assert.assertEquals(true,count > 83);
  }
  finally {
    sqlSession.close();
  }
}
