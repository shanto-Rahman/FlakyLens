@Test public void settingIncludeCallerDataPropertyCausedCallerDataToBeIncluded(){
assertEquals(1,listAppender.list.size());
assertTrue(e.hasCallerData());
assertEquals(thisClassName,ste.getClassName());
}