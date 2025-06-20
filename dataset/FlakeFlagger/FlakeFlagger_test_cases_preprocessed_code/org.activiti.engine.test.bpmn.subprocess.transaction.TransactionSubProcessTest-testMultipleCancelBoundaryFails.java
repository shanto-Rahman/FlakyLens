public void testMultipleCancelBoundaryFails(){
fail("exception expected");
if (!e.getMessage().contains("multiple boundary events with cancelEventDefinition not supported on same transaction")) {
fail("different exception expected");
}
}