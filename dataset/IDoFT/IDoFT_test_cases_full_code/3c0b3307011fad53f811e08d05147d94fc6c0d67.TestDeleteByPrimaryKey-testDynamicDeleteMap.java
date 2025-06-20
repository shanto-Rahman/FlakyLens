/** 
 * Map可以随意
 */
@Test public void testDynamicDeleteMap(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Map map=new HashMap();
    map.put("id",100);
    Assert.assertEquals(1,mapper.deleteByPrimaryKey(map));
    map=new HashMap();
    map.put("countryname","China");
    Assert.assertEquals(0,mapper.deleteByPrimaryKey(map));
  }
  finally {
    sqlSession.close();
  }
}
