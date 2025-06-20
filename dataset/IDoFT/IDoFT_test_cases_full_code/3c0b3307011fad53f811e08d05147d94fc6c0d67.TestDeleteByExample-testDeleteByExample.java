@Test public void testDeleteByExample(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Example example=new Example(Country.class);
    example.createCriteria().andGreaterThan("id",100);
    int count=mapper.deleteByExample(example);
    Assert.assertEquals(83,count);
  }
  finally {
    sqlSession.rollback();
    sqlSession.close();
  }
}
