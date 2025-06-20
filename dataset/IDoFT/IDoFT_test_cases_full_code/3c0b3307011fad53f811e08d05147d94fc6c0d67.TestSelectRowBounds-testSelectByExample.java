@Test public void testSelectByExample(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Example example=new Example(Country.class);
    example.createCriteria().andGreaterThan("id",100).andLessThan("id",151);
    example.or().andLessThan("id",41);
    List<Country> countries=mapper.selectByExampleAndRowBounds(example,new RowBounds(10,20));
    Assert.assertEquals(20,countries.size());
  }
  finally {
    sqlSession.close();
  }
}
