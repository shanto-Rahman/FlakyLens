@Test public void testEnumMapKeys_asInlineUnion(){
assertTrue(output.contains("labels: { [P in 'North' | 'East' | 'South' | 'West']?: string }".replace('\'','"')));
assertTrue(!output.contains("Direction"));
}