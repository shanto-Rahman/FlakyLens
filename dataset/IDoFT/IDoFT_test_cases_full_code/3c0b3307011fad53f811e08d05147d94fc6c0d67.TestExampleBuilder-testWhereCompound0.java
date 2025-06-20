@Test public void testWhereCompound0(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    List<Country> countries=mapper.selectByExample(Example.builder(Country.class).where(Sqls.custom().andEqualTo("countryname","China").andEqualTo("id",35).orIn("id",new ArrayList<Integer>(Arrays.asList(35,183))).orLike("countryname","Ye%")).build());
    Country country35=countries.get(2);
    Assert.assertEquals(Integer.valueOf(35),country35.getId());
    Assert.assertEquals("China",country35.getCountryname());
    Assert.assertEquals("CN",country35.getCountrycode());
    Country country183=countries.get(0);
    Assert.assertEquals(Integer.valueOf(183),country183.getId());
    Assert.assertEquals("Zambia",country183.getCountryname());
    Assert.assertEquals("ZM",country183.getCountrycode());
    Country country179=countries.get(1);
    Assert.assertEquals(Integer.valueOf(179),country179.getId());
    Assert.assertEquals("Yemen",country179.getCountryname());
    Assert.assertEquals("YE",country179.getCountrycode());
  }
  finally {
    sqlSession.close();
  }
}
