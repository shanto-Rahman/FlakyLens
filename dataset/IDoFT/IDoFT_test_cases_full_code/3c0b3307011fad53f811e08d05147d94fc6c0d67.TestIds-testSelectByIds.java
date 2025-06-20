@Test public void testSelectByIds(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    List<Country> countryList=mapper.selectByIds("1,2,3");
    Assert.assertEquals(3,countryList.size());
  }
  finally {
    sqlSession.close();
  }
}
