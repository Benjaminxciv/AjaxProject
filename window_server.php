<?php 
  $state = $_REQUEST["state"];
  
  $cellNum = $_REQUEST["cellNum"];
  
  $alarm_state = "off";
  //$windows = array("1" => "locked", "2" => "locked", "3"=> "locked","4" => "locked", "5" => "locked");
  if($state != "locked")
  {
    $alarm_state = "on";
  }
  
  print $alarm_state;

?> 
