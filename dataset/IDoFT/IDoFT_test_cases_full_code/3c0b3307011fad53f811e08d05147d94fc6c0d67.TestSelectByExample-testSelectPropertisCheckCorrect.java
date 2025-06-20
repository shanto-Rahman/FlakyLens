/** 
 * 指定查询字段正确
 */
@Test public void testSelectPropertisCheckCorrect(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Example example=new Example(Country.class);
    example.selectProperties(new String[]{"countryname"});
    example.createCriteria().andEqualTo("id",35);
    List<Country> country1=mapper.selectByExample(example);
    Assert.assertEquals(null,country1.get(0).getId());
    Assert.assertEquals("China",country1.get(0).getCountryname());
    Assert.assertEquals(null,country1.get(0).getCountrycode());
  }
  finally {
    sqlSession.close();
  }
}
