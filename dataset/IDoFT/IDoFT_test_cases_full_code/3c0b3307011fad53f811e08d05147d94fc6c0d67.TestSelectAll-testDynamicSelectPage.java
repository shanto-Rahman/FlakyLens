/** 
 * 查询全部
 */
@Test public void testDynamicSelectPage(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    List<Country> countryList=mapper.selectAll();
    Assert.assertEquals(183,countryList.size());
  }
  finally {
    sqlSession.close();
  }
}
