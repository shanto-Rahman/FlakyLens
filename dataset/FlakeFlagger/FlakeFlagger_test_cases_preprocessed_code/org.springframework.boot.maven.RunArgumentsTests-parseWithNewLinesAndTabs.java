@Test public void parseWithNewLinesAndTabs(){
assertEquals(2,args.length);
assertEquals("-Dfoo=bar",args[0]);
assertEquals("-Dfoo2=bar2",args[1]);
}