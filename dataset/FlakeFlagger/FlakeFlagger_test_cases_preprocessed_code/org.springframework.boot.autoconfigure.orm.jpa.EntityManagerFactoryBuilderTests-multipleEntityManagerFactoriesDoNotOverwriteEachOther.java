@Test public void multipleEntityManagerFactoriesDoNotOverwriteEachOther(){
assertFalse(result1.getJpaPropertyMap().isEmpty());
assertTrue(result2.getJpaPropertyMap().isEmpty());
}