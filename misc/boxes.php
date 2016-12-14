/*
   A large box can hold five items, while the small box can hold only one
   item. All items must be placed in boxes and used boxes have to be
   filled up completely.

   Write a function that calculates the minimum number of boxes needed to
   hold a given number of items. If it's not possible to meet the
   requirements, return -1.

   Example: if we have 12 products, 3 large and 3 small boxes, the
   function should return 4 (2 large boxes + 2 small boxes).
*/


<?php


  class Shipment {

    private $items;
    private $idealTotalBoxes;
    private $minBoxes;
    private $canPack;

    function __construct($items, $minBoxes = null, $idealTotalBoxes = null, $canPack = 'TBD') {
      $this->items = $items;
      $this->minBoxes = $minBoxes;
      $this->idealTotalBoxes = $idealTotalBoxes;
      $this->canPack = $canPack;
    }

    public function process() {

      //other classes may want to know how many boxes are availble
      //for example, could have a class that is specifically for
      //checking and restocking boxes
      static $largeBoxesAvailable = 18;
      static $smallBoxesAvailable = 13;

      $idealLargeBoxes = floor($this->items / 5);
      $idealSmallBoxes = $this->items % 5;

      $itemsToPack = $this->items;
      $this->idealTotalBoxes = $idealLargeBoxes + $idealSmallBoxes;

      //packing
      while ($itemsToPack > 0) {
        //pack as many as we can into large boxes
        if ($largeBoxesAvailable > 0 && ($itemsToPack / 5 > 1)) {
          $itemsToPack = $itemsToPack - 5;
          $largeBoxesAvailable = $largeBoxesAvailable - 1;
          $this->minBoxes++;

          //place remainder in smallBoxes
        } else if ($smallBoxesAvailable > 0 && ($itemsTopack / 5 < 1)) {
          $itemsToPack = $itemsToPack - 1;
          $smallBoxesAvailable = $smallBoxesAvailable - 1;
          $this->minBoxes++;
        } else if ($smallBoxesAvailable + $largeBoxesAvailable === 0){
          break;
        }

      }

      if ($itemsToPack > 0 && ($largeBoxesAvailable + $smallBoxesAvailable === 0)) {

        $this->canPack = false;
        $this->minBoxes = 'cannot ship';
        return -1;
      } else if ($itemsToPack === 0){
        $this->canPack = true;
        $remainingBoxes = $largeBoxesAvailable + $smallBoxesAvailable;
        echo("LargeBoxes: " . $largeBoxesAvailable . " ");
        echo("SmallBoxes: " . $smallBoxesAvailable . " ");
        echo("TotalBoxes Remaining: " . $remainingBoxes);
        echo("\n");
        return $this->minBoxes;
      }


    }

  }

  $shipmentOne = new Shipment(18);
  $shipmentTwo = new Shipment(47);
  $shipmentThree = new Shipment(800);

  echo($shipmentOne->process());
  echo("\n");
  var_dump($shipmentOne);
  echo("\n");
  echo($shipmentTwo->process());
  echo("\n");
  var_dump($shipmentTwo);
  echo($shipmentThree->process());
  echo("\n");
  var_dump($shipmentThree);
