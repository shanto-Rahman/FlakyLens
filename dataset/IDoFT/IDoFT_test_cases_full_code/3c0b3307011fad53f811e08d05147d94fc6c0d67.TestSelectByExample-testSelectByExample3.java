@Test public void testSelectByExample3(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    CountryExample example=new CountryExample();
    example.createCriteria().andCountrynameLike("A%");
    example.or().andIdGreaterThan(100);
    example.setDistinct(true);
    List<Country> countries=mapper.selectByExample(example);
    Assert.assertEquals(true,countries.size() > 83);
  }
  finally {
    sqlSession.close();
  }
}
