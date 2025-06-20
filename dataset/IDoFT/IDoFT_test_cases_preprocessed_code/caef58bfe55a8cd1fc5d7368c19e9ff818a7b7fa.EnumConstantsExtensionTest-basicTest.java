@Test public void basicTest(){
Assert.assertEquals(7,lines.size());
Assert.assertEquals("",lines.get(0));
Assert.assertEquals("const Direction = {",lines.get(1));
Assert.assertEquals(indent + "North: <Direction>\"North\",",lines.get(2));
Assert.assertEquals(indent + "East: <Direction>\"East\",",lines.get(3));
Assert.assertEquals(indent + "South: <Direction>\"South\",",lines.get(4));
Assert.assertEquals(indent + "West: <Direction>\"West\",",lines.get(5));
Assert.assertEquals("}",lines.get(6));
}