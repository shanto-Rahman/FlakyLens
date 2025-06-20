@Test public void testSelectByExample4(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    Country ct=new Country();
    ct.setCountryname("China");
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Example example=new Example(Country.class);
    example.createCriteria().andGreaterThan("id",20).andEqualTo(ct);
    List<Country> countries=mapper.selectByExample(example);
    System.out.println(countries.get(0).toString());
    Assert.assertEquals(1,countries.size());
  }
  finally {
    sqlSession.close();
  }
}
