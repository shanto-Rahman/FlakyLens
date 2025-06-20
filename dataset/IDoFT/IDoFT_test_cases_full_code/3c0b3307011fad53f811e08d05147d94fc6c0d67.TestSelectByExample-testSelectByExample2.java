@Test public void testSelectByExample2(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Example example=new Example(Country.class);
    example.createCriteria().andLike("countryname","A%");
    example.or().andGreaterThan("id",100);
    example.setDistinct(true);
    List<Country> countries=mapper.selectByExample(example);
    Assert.assertEquals(true,countries.size() > 83);
  }
  finally {
    sqlSession.close();
  }
}
