@Test public void testSelectByExampleForUpdate(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Example example=new Example(Country.class);
    example.setForUpdate(true);
    example.createCriteria().andGreaterThan("id",100).andLessThan("id",151);
    example.or().andLessThan("id",41);
    List<Country> countries=mapper.selectByExample(example);
    Assert.assertEquals(90,countries.size());
  }
  finally {
    sqlSession.close();
  }
}
