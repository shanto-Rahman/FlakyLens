@Test(expected=TooManyResultsException.class) public void testSelectOneByExampleException(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Example example=new Example(Country.class);
    example.createCriteria().andGreaterThan("id",100).andLessThan("id",151);
    example.or().andLessThan("id",41);
    mapper.selectOneByExample(example);
  }
  finally {
    sqlSession.close();
  }
}
