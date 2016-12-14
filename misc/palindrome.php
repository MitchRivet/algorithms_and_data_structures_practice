/*
   Write a function that checks if a given sentence is a palindrome. A
   palindrome is a word, phrase, verse, or sentence that reads the same
   backward or forward. Only the order of English alphabet letters (A-Z
   and a-z) should be considered, other characters should be ignored.
*/

//reverse order of array
//array reverse should preserve spaces if there were any

$lowerCaseNoSpaces = str_replace(" ", "", strtolower($string));

$reversed = implode("", array_reverse(str_split($lowerCaseNoSpaces));

if ($reversed == $lowerCaseNoSpaces) {
  return true;
} else {
  return false;
}
