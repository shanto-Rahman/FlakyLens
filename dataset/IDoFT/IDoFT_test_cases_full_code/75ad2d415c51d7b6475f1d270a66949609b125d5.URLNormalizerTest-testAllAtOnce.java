@Test public void testAllAtOnce(){
  s="https://www.Example.org/0/../1/././%7ea_b:c\\d_|e~f!g " + "h/./^i^J[k]//l./m/n/o/../../p/q/r?cc=&dd=ee&bb=aa" + "#fragment";
  t="http://example.org/1/~a_b:c%5Cd_%7Ce~f!g%20h/%5Ei%5EJ%5Bk%5D/l./" + "m/p/q/r/?bb=aa&dd=ee";
  URLNormalizer n=new URLNormalizer(s).addDirectoryTrailingSlash().addWWW().removeFragment().decodeUnreservedCharacters().encodeNonURICharacters().lowerCaseSchemeHost().removeDefaultPort().removeDotSegments().removeDuplicateSlashes().removeEmptyParameters().removeSessionIds().removeTrailingQuestionMark().removeWWW().sortQueryParameters().unsecureScheme().upperCaseEscapeSequence();
  assertEquals(t,n.toString());
  assertEquals(t,n.toURL().toString());
  assertEquals(t,n.toURI().toString());
}
