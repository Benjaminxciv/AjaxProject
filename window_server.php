<?php 
  $state = $_REQUEST["state"];
  
  $cellNum = $_REQUEST["cellNum"];

  $windows = array("1" => "locked", "2" => "locked", "3"=> "locked","4" => "locked", "5" => "locked");
 
  $windows[$cellNum] = $state;

  print "<p>The window in cell [" .$cellNum. "] state: $windows[$cellNum]</p> ";
?> 
