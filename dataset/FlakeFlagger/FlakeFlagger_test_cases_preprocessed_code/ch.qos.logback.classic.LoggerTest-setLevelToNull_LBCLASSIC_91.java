@Test public void setLevelToNull_LBCLASSIC_91(){
assertEquals(root.getEffectiveLevel(),loggerTest.getEffectiveLevel());
assertEquals(root.getEffectiveLevel(),child.getEffectiveLevel());
}