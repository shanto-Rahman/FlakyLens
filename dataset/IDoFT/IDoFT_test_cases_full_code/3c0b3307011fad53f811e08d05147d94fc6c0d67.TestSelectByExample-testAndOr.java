@Test public void testAndOr(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Example example=new Example(Country.class);
    example.createCriteria().andGreaterThan("id",100).andLessThan("id",151);
    example.or().andLessThan("id",41);
    List<Country> countries=mapper.selectByExample(example);
    Assert.assertEquals(90,countries.size());
    example=new Example(Country.class);
    example.createCriteria();
    example.or();
    example.and();
    countries=mapper.selectByExample(example);
    Assert.assertEquals(183,countries.size());
  }
  finally {
    sqlSession.close();
  }
}
