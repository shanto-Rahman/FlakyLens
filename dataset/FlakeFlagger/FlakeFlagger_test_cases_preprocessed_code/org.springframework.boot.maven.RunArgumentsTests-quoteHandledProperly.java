@Test public void quoteHandledProperly(){
assertEquals(1,args.length);
assertEquals("-Dvalue=My Value",args[0]);
}