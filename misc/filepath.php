<?php
//two times down
//three times up
//complex paths

class Path
{
    public $currentPath;

    function __construct($path)
    {
        $this->currentPath = $path;
    }

    public function cd($newPath)
    {
      $howFarBack = substr_count($newPath, '..');

      $cdPath = explode('/', $newPath);
      $oldPath = explode('/', $this->currentPath);

      $oldPathLength = count($oldPath);
      $newPathLength = count($cdPath);
      $finalPath = "";

      for ($i = 0; $i < ($oldPathLength - $howFarBack); $i++) {
          $finalPath .= $oldPath[$i] . "/";
      }

      for ($i = 0; $i < $newPathLength; $i++) {
        if ($cdPath[$i] != "..") {
          $finalPath .= $cdPath[$i] . "/";
        }
      }

      if (substr($finalPath, -1) === "/") {
        $finalPath = rtrim($finalPath, "/");
      }

      return new Path($finalPath);
    }
}

$path = new Path('/a/b/c/d');

echo($path->cd('../../x')->currentPath);
