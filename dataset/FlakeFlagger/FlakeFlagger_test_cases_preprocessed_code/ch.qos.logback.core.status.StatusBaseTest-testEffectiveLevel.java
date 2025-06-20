public void testEffectiveLevel(){
assertEquals("effective level misevaluated",status.getEffectiveLevel(),Status.ERROR);
assertEquals("effective level misevaluated",status.getEffectiveLevel(),Status.WARN);
assertEquals("effective level misevaluated",status.getEffectiveLevel(),Status.ERROR);
}