/** 
 * 查询全部
 */
@Test public void testDynamicSelectPage2(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    List<Country> countryList=mapper.selectAll();
    Assert.assertEquals(183,countryList.size());
    Assert.assertEquals(183,(int)countryList.get(0).getId());
  }
  finally {
    sqlSession.close();
  }
}
