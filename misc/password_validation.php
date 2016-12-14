   Implement the strongPassword function, which accepts a password and
   returns true if the password is strong and false if it's not.

   A password is strong if it satisfies the following rules:

   It is at least 12 characters long.

   It contains at least one uppercase letter, at least one lowercase
   letter and at least one digit.

   Letters should be split by digits into at least two groups (like
   "Strong1Password").

   For example, "strong1password" is not a strong password because it
   does not contain any uppercase letters.

   $charArray = str_split($password);
   $split;

   for($i = 1; $i < count($charArray); $i++) {
     if (is_numeric($charArray[$i]) && ctype_alpha( $charArray[$i -1]) && ctype_alpha($charArray[$i + 1]) ) {
       $split = true;
       break;
     }
   }

   if (strlen($password) < 12) {
     return false;
   } else if (preg_match('/[A-Z]+[a-z]+[0-9]+/', $password) == false) {
     return false;
   } else if ($split != true) {
     return false;
   } else {
     return true;
   }

   //letters split by digits... does this mean digits cannot start the password?
   // i.e. is '1Wasdasdf5asdfads6' strong? or '12342Wa3d12234'?
   //it seems that they mean there is at least one number with a letter on either side
   //loop through and return if you find a number
