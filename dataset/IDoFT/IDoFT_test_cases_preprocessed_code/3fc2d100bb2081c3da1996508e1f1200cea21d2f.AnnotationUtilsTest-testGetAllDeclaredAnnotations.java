@Test public void testGetAllDeclaredAnnotations(){
assertTrue(isSameType(annotations.get(0),Service5.class));
assertTrue(isSameType(annotations.get(0),MyAdaptive.class));
assertTrue(isSameType(annotations.get(1),Service5.class));
assertArrayEquals(new String[]{"e"},myAdaptive.value());//IT
assertArrayEquals(new String[]{"f"},adaptive.value());
}