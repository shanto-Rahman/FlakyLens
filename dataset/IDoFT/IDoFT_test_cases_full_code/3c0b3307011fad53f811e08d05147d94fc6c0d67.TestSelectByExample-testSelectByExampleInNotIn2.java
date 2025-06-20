@Test public void testSelectByExampleInNotIn2(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Example example=new Example(Country.class);
    example.createCriteria().andIn("id",Arrays.asList(new Integer[]{1,2,3,4,5,6,7,8,9,10,11})).andNotIn("id",Arrays.asList(new Object[]{11}));
    List<Country> countries=mapper.selectByExample(example);
    Assert.assertEquals(10,countries.size());
  }
  finally {
    sqlSession.close();
  }
}
