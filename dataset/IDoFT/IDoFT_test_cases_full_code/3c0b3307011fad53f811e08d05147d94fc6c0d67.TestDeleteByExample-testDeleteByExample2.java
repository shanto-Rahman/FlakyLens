@Test public void testDeleteByExample2(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Example example=new Example(Country.class);
    example.createCriteria().andLike("countryname","A%");
    example.or().andGreaterThan("id",100);
    example.setDistinct(true);
    int count=mapper.deleteByExample(example);
    Assert.assertEquals(true,count > 83);
  }
  finally {
    sqlSession.rollback();
    sqlSession.close();
  }
}
