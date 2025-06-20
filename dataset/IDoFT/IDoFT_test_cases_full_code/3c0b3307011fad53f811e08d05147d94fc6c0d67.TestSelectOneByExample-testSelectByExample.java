@Test public void testSelectByExample(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Example example=new Example(Country.class);
    example.createCriteria().andGreaterThan("id",100).andLessThan("id",102);
    Country country=mapper.selectOneByExample(example);
    Assert.assertNotNull(country);
    Assert.assertEquals(new Integer(101),country.getId());
  }
  finally {
    sqlSession.close();
  }
}
