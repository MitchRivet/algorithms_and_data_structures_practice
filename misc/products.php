<?php
class Products
{
    public static function sortByPriceAscending($jsonString)
    {
        $cmp = function($a, $b)
         {
            return $a['price'] - $b['price'];
         };
         //decode json string
          $info = json_decode($jsonString);
          //sort array by val using a user-defined comparison function
          usort($info, $cmp);
          
          print_r($info);
    }



}

// For testing purposes (do not submit uncommented)
echo Products::sortByPriceAscending('[{"name":"eggs","price":1},{"name":"coffee","price":9.99},{"name":"rice","price":4.04}]');
