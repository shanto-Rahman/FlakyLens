public void testAmericanActorChrisPratt(){
assertTrue("No first extraction for sentence!",extraction.isPresent());
assertEquals("1.0\tChris Pratt\tis actor of\tAmerican",extraction.get().toString());
assertTrue("No second extraction for sentence!",extraction.isPresent());
assertEquals("1.0\tChris Pratt\tis\tAmerican",extraction.get().toString());
assertTrue("No third extraction for sentence!",extraction.isPresent());
assertEquals("1.0\tChris Pratt\tis\tactor",extraction.get().toString());
}