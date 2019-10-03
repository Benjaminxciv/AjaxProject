<?php 
 
  //Requesting variables from client
  $state    = $_REQUEST["state"];
  $cell_num  = $_REQUEST["cellNum"];
  
  $alarm_state = "off";
  
  if($state != "locked")
  {
    $alarm_state = "on";
  }
  
  //Return this status message to client
  print $alarm_state.$state;

  $log = fopen("windowlog.txt", "a") or die("Unable to open file!"); 
  fwrite($log,"Cell ".$cell_num." - State: ".$state." - Alarm State: ".$alarm_state."\n");
  fclose($log);

?> 
