@Test public void testDeepToString(){
assertThat(row.toString(),equalTo("-U{" + "a=1, " + "b=hello, "+ "c=null, "+ "d=(2,hi), "+ "e=hello world, "+ "f=[[1], null, [3, 4]], "+ "g=[[true], null, [false, false]], "+ "h={a=[1, 2, 3, 4], b=[], c=null}"+ "}"));
}