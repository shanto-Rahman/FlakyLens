@Test public void testCalciumParsing() throws StructureException, IOException {
assertEquals(g1.getAtom(0).getName(),"CA");
assertEquals(g1.getAtom(0).getElement(),Element.Ca);
assertEquals(g1.getAtom(0).getName(),g2.getAtom(0).getName());
}