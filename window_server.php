<?php 
 
  //Requesting variables from client
  $state    = $_REQUEST["state"];
  $cellNum  = $_REQUEST["cellNum"];
  
  $alarm_state = "off";
  
  if($state != "locked")
  {
    $alarm_state = "on";
  }
  
  //Return this status message to client
  print $alarm_state.$state;

?> 
