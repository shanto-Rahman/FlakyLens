@Test public void testIncludeStringValue(){
  assertThat(mapBuilder.add("message",true,message).build()).containsOnly(entry("message",message));
}
