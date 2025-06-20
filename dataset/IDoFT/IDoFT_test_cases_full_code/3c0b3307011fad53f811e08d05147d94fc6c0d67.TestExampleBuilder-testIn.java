@Test public void testIn(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Example example=Example.builder(Country.class).where(Sqls.custom().andIn("id",new ArrayList<Integer>(Arrays.asList(35,183)))).build();
    List<Country> countries=mapper.selectByExample(example);
    Country country35=countries.get(1);
    Assert.assertEquals(Integer.valueOf(35),country35.getId());
    Assert.assertEquals("China",country35.getCountryname());
    Assert.assertEquals("CN",country35.getCountrycode());
    Country country183=countries.get(0);
    Assert.assertEquals(Integer.valueOf(183),country183.getId());
    Assert.assertEquals("Zambia",country183.getCountryname());
    Assert.assertEquals("ZM",country183.getCountrycode());
  }
  finally {
    sqlSession.close();
  }
}
